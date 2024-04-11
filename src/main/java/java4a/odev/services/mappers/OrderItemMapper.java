package java4a.odev.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java4a.odev.entities.OrderItem;
import java4a.odev.services.dtos.requests.orderitems.AddOrderItemRequest;
import java4a.odev.services.dtos.responses.orderitems.AddOrderItemResponse;
import java4a.odev.services.dtos.responses.orderitems.ListOrderItemResponse;

@Mapper
public interface OrderItemMapper {

	OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

	@Mapping(target = "productId", source = "product.id")
	@Mapping(target = "productName", source = "product.name")
	@Mapping(target = "orderId", source = "order.id")
	ListOrderItemResponse listResponseFromOrderItem(OrderItem orderItem);

	@Mapping(target = "product.id", source = "productId")
	@Mapping(target = "order.id", source = "orderId")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "totalPrice", ignore = true)
	OrderItem orderItemFromAddRequest(AddOrderItemRequest request);

	@Mapping(target = "orderId", source = "order.id")
	@Mapping(target = "productId", source = "product.id")
	@Mapping(target = "productName", source = "product.name")
	AddOrderItemResponse addResponseFromOrderItem(OrderItem orderItem);
}
