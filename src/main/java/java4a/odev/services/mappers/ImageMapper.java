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



@Mapper

public interface ImageMapper {

    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);
    UpdateImageResponse updateImageResponseFromImage(Image image);


    ListImageResponse toListImageResponse(Image images);



    //add
    @Mapping(target = "product.id" , source = "productId")
    Image imageFromAddRequest(AddImageRequest request);

    @Mapping(target = "productId" , source = "product.id")
    AddImageResponse addResponseFromImage(Image image);

 // update

    @Mapping(source = "productId" , target = "product.id")
    Image imageFromUpdateRequest(UpdateImageRequest request);

    @Mapping(source = "product.id" , target = "productId")
    AddImageResponse updateResponseFromImage(Image image);



    //list

    @Mapping(source = "product.name", target = "productName")
    ListImageResponse listResponseFromImage(Image image);



}

