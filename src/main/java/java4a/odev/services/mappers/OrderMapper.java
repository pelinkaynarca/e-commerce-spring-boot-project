package java4a.odev.services.mappers;

import java4a.odev.entities.Order;
import java4a.odev.entities.OrderItem;
import java4a.odev.services.dtos.requests.cartitems.ListCartItemRequest;
import java4a.odev.services.dtos.requests.orders.AddOrderRequest;
import java4a.odev.services.dtos.responses.orders.AddOrderResponse;
import java4a.odev.services.dtos.responses.orders.ListOrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "user.id", source = "userId")
    })
    Order orderFromAddRequest(AddOrderRequest request);

    @Mappings({
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "userFirstName", source = "user.firstName"),
            @Mapping(target = "userLastName", source = "user.lastName"),
            @Mapping(target = "cartItems", expression = "java(mapOrderItemsToCartItemRequests(order.getOrderItems()))")
    })
    AddOrderResponse addResponseFromOrder(Order order);

    @Mappings({
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "userFirstName", source = "user.firstName"),
            @Mapping(target = "userLastName", source = "user.lastName"),
            @Mapping(target = "orderTotal", expression = "java(calculateOrderTotal(order.getOrderItems()))"),
            @Mapping(target = "productNames", expression = "java(getProductNames(order.getOrderItems()))")
    })
    ListOrderResponse listResponseFromOrder (Order order);

    List<ListOrderResponse> ListResponseListFromOrderList(List<Order> orders);

    default List<String> getProductNames(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(orderItem -> orderItem.getProduct().getName())
                .collect(Collectors.toList());
    }
    default List<ListCartItemRequest> mapOrderItemsToCartItemRequests(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(orderItem -> {
                    ListCartItemRequest cartItemRequest = new ListCartItemRequest();
                    cartItemRequest.setProductId(orderItem.getProduct().getId());
                    return cartItemRequest;
                })
                .collect(Collectors.toList());
    }
    default double calculateOrderTotal(List<OrderItem> orderItems) {
        return orderItems.stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();
    }
}
