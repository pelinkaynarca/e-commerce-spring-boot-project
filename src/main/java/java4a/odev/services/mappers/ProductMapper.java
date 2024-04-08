package java4a.odev.services.mappers;

import java4a.odev.entities.Product;
import java4a.odev.services.dtos.requests.products.AddProductRequest;
import java4a.odev.services.dtos.responses.products.AddProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	@Mapping(target = "category.id", source = "categoryId")
	Product productFromAddRequest(AddProductRequest request);

	@Mapping(target = "categoryId", source = "category.id")
	@Mapping(target = "categoryName", source = "category.name")
	AddProductResponse addResponseFromProduct(Product product);
}
