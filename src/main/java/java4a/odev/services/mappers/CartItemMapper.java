package java4a.odev.services.mappers;

import java4a.odev.services.dtos.requests.cartitems.AddCartItemRequest;
import java4a.odev.services.dtos.requests.cartitems.UpdateCartItemRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java4a.odev.entities.CartItem;
import java4a.odev.services.dtos.responses.cartitems.AddCartItemResponse;
import java4a.odev.services.dtos.responses.cartitems.ListCartItemResponse;
import java4a.odev.services.dtos.responses.cartitems.UpdateCartItemResponse;

@Mapper
public interface CartItemMapper {

	CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);

	@Mapping(target = "productName", source = "product.name")
	@Mapping(target = "userFirstName", source = "user.firstName")
	@Mapping(target = "userLastName", source = "user.lastName")
	ListCartItemResponse listResponseFromCartItem(CartItem cartItem);

	@Mapping(target = "product.id", source = "productId")
	@Mapping(target = "user.id", source = "userId")
	@Mapping(target = "id", ignore = true)
	CartItem cartItemFromAddRequest(AddCartItemRequest request);

	@Mapping(target = "productName", source = "product.name")
	@Mapping(target = "userFirstName", source = "user.firstName")
	@Mapping(target = "userLastName", source = "user.lastName")
	AddCartItemResponse addResponseFromCartItem(CartItem cartItem);

	@Mapping(target = "product.id", source = "productId")
	@Mapping(target = "user.id", source = "userId")
	@Mapping(target = "id", ignore = true)
	CartItem cartItemFromUpdateRequest(UpdateCartItemRequest request);

	@Mapping(target = "productName", source = "product.name")
	@Mapping(target = "userFirstName", source = "user.firstName")
	@Mapping(target = "userLastName", source = "user.lastName")
	UpdateCartItemResponse updateResponseFromCartItem(CartItem cartItem);

}
