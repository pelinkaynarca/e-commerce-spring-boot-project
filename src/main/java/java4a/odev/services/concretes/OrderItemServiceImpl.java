package java4a.odev.services.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import java4a.odev.core.utils.exceptions.types.BusinessException;
import java4a.odev.entities.OrderItem;
import java4a.odev.entities.Product;
import java4a.odev.repositories.OrderItemRepository;
import java4a.odev.repositories.ProductRepository;
import java4a.odev.services.abstracts.OrderItemService;
import java4a.odev.services.dtos.requests.orderitems.AddOrderItemRequest;
import java4a.odev.services.dtos.responses.orderitems.AddOrderItemResponse;
import java4a.odev.services.dtos.responses.orderitems.ListOrderItemResponse;
import java4a.odev.services.mappers.OrderItemMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

	private OrderItemRepository orderItemRepository;
	private ProductRepository productRepository;

	@Override
	public List<ListOrderItemResponse> getAll() {
		List<OrderItem> orderItems = orderItemRepository.findAll();
		List<ListOrderItemResponse> listOrderItemResponses = new ArrayList<ListOrderItemResponse>();
		for (OrderItem orderItem : orderItems) {
			listOrderItemResponses.add(OrderItemMapper.INSTANCE.listResponseFromOrderItem(orderItem));
		}
		return listOrderItemResponses;
	}

	@Override
	public ListOrderItemResponse getById(int id) {
		OrderItem orderItem = orderItemRepository.findById(id)
				.orElseThrow(() -> new BusinessException("Sipariş kalemi bulunamadı."));
		return OrderItemMapper.INSTANCE.listResponseFromOrderItem(orderItem);
	}

	@Override
	public AddOrderItemResponse add(AddOrderItemRequest request) {
		productShouldExistAndMustBeInStock(request.getProductId(), request.getQuantity());
		OrderItem orderItem = OrderItemMapper.INSTANCE.orderItemFromAddRequest(request);
		OrderItem savedOrderItem = orderItemRepository.save(orderItem);

		// Ürün stogunu güncelle
		Product product = productRepository.findById(request.getProductId()).orElseThrow();
		product.setStockQuantity(product.getStockQuantity() - request.getQuantity());
		productRepository.saveAndFlush(product);
//		orderItemRepository.flush();
		return OrderItemMapper.INSTANCE.addResponseFromOrderItem(savedOrderItem);
	}

	@Override
	public void delete(int id) {
		orderItemRepository.deleteById(id);
	}

	private void productShouldExistAndMustBeInStock(int productId, int requestedQuantity) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new BusinessException(productId + " id'li ürün bulunamadı."));
		if (product.getStockQuantity() < requestedQuantity) {
			throw new BusinessException(product.getName() + " isimli üründen stokta yeterli miktarda bulunmamaktadır.");
		}
	}
}
