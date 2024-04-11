package java4a.odev.services.mappers;

import java4a.odev.entities.Product;
import java4a.odev.services.dtos.requests.products.AddProductRequest;
import java4a.odev.services.dtos.requests.products.UpdateProductRequest;
import java4a.odev.services.dtos.responses.products.AddProductResponse;
import java4a.odev.services.dtos.responses.products.ListProductResponse;
import java4a.odev.services.dtos.responses.products.UpdateProductResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	@Mapping(target = "category.id", source = "categoryId")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "cartItems", ignore = true)
	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "modifiedAt", ignore = true)
	@Mapping(target = "images", ignore = true)
	@Mapping(target = "orderItems", ignore = true)
	Product productFromAddRequest(AddProductRequest request);

	@Mapping(target = "categoryId", source = "category.id")
	@Mapping(target = "categoryName", source = "category.name")
	AddProductResponse addResponseFromProduct(Product product);

	@Mapping(target = "categoryId", source = "category.id")
	@Mapping(target = "categoryName", source = "category.name")
	ListProductResponse listResponseFromProduct(Product product);

	@Mapping(target = "category.id", source = "categoryId")
	@Mapping(target = "cartItems", ignore = true)
	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "modifiedAt", ignore = true)
	@Mapping(target = "images", ignore = true)
	@Mapping(target = "orderItems", ignore = true)
	Product productFromUpdateRequest(UpdateProductRequest request);

	@Mapping(target = "categoryId", source = "category.id")
	@Mapping(target = "categoryName", source = "category.name")
	UpdateProductResponse updateResponseFromProduct(Product product);
}
