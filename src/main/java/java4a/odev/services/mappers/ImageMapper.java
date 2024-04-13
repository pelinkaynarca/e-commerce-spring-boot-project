package java4a.odev.services.mappers;

import java4a.odev.entities.Image;
import java4a.odev.services.dtos.requests.images.AddImageRequest;
import java4a.odev.services.dtos.requests.images.UpdateImageRequest;
import java4a.odev.services.dtos.responses.images.AddImageResponse;

import java4a.odev.services.dtos.responses.images.ListImageResponse;
import java4a.odev.services.dtos.responses.images.UpdateImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface ImageMapper {

    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

    @Mapping(target = "product.id" , source = "productId")
    Image imageFromAddRequest(AddImageRequest request);

    @Mapping(target = "productId" , source = "product.id")
    AddImageResponse addResponseFromImage(Image image);

    @Mapping(source = "productId" , target = "product.id")
    Image imageFromUpdateRequest(UpdateImageRequest request);

    @Mapping(source = "product.id" , target = "productId")
    UpdateImageResponse updateResponseFromImage(Image image);

    List<ListImageResponse> ListResponseFromImage(List<Image> image);

    @Mapping(source = "product.id", target = "productId")
    ListImageResponse ListImageResponse(Image image);
}

