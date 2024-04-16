package java4a.odev.services.concretes;

import java4a.odev.core.utils.exceptions.types.BusinessException;
import java4a.odev.entities.*;
import java4a.odev.repositories.*;
import java4a.odev.services.abstracts.OrderService;
import java4a.odev.services.dtos.requests.cartitems.ListCartItemRequest;
import java4a.odev.services.dtos.requests.orders.AddOrderRequest;
import java4a.odev.services.dtos.responses.orders.AddOrderResponse;
import java4a.odev.services.dtos.responses.orders.ListOrderResponse;
import java4a.odev.services.mappers.OrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private UserRepository userRepository;
    private CartItemRepository cartItemRepository;

    @Override
    public List<ListOrderResponse> getAll() {
        List<Order> orders = orderRepository.findAll();
        return OrderMapper.INSTANCE.ListResponseListFromOrderList(orders);
    }

    @Override
    public ListOrderResponse getById(int id) {
        Order order = getOrderById(id);
        return OrderMapper.INSTANCE.listResponseFromOrder(order);
    }

    @Override
    public AddOrderResponse add(AddOrderRequest request) {
        User user = validateUserId(request.getUserId());
        validateProductIds(request.getCartItems());

        Order order = OrderMapper.INSTANCE.orderFromAddRequest(request);
        createOrder(user);

        List<OrderItem> orderItems = createOrderItems(request.getCartItems(), order);
        order.setOrderItems(orderItems);

        Order savedOrder = saveOrder(order);

        updateProductStocks(savedOrder.getOrderItems());

        return OrderMapper.INSTANCE.addResponseFromOrder(savedOrder);
    }

    @Override
    public void delete(int id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }

    private void createOrder(User user) {
        Order order = new Order();
        order.setUser(user);
    }

    private List<OrderItem> createOrderItems(List<ListCartItemRequest> cartItems, Order order) {
        List<OrderItem> orderItems = new ArrayList<>();

        cartItems.forEach(cartItem -> {
            int productId = cartItem.getProductId();
            CartItem cartItemToProcess = findCartItem(order.getUser().getId(), productId);

            Product product = getProductById(productId);
            validateProductStock(product, cartItemToProcess.getQuantity());

            OrderItem orderItem = createOrderItem(order, product, cartItemToProcess.getQuantity());
            orderItems.add(orderItem);

            cartItemRepository.delete(cartItemToProcess);
        });

        return orderItems;
    }

    private OrderItem createOrderItem(Order order, Product product, int quantity) {
        double totalPrice = product.getUnitPrice() * quantity;

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        orderItem.setTotalPrice(totalPrice);

        return orderItem;
    }

    private Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    private void updateProductStocks(List<OrderItem> orderItems) {
        for (OrderItem orderItem : orderItems) {
            Product product = productRepository.findById(orderItem.getProduct().getId())
                    .orElseThrow(() -> new BusinessException("Ürün bulunamadı."));

            int newStockQuantity = product.getStockQuantity() - orderItem.getQuantity();
            product.setStockQuantity(newStockQuantity);

            productRepository.save(product);
        }
    }

    private User validateUserId(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BusinessException(id + " ID'sine sahip bir kullanıcı bulunamadı."));
    }

    private void validateProductIds(List<ListCartItemRequest> cartItems) {
        for (ListCartItemRequest cartItem : cartItems) {
            productRepository.findById(cartItem.getProductId())
                    .orElseThrow(() -> new BusinessException("ID'si " + cartItem.getProductId() + " olan ürün bulunamadı."));
        }
    }

    private CartItem findCartItem(int userId, int productId) {
        return cartItemRepository.findByUserIdAndProductId(userId, productId)
                .orElseThrow(() -> new BusinessException("Ürün sepetinizde bulunamadı."));
    }

    private Product getProductById(int productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new BusinessException("Ürün bulunamadı."));
    }

    private void validateProductStock(Product product, int requestedQuantity) {
        if (product.getStockQuantity() < requestedQuantity) {
            throw new BusinessException(product.getName() + " isimli üründen stokta yeterli miktar bulunmamaktadır.");
        }
    }

    private Order getOrderById(int id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new BusinessException("ID'si " + id + " olan sipariş bulunamadı."));
    }
}