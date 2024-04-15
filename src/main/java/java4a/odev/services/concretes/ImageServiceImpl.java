package java4a.odev.services.concretes;

import java4a.odev.core.utils.exceptions.types.BusinessException;
import java4a.odev.entities.Image;
import java4a.odev.repositories.ImageRepository;
import java4a.odev.services.abstracts.ImageService;
import java4a.odev.services.dtos.requests.images.AddImageRequest;
import java4a.odev.services.dtos.requests.images.UpdateImageRequest;
import java4a.odev.services.dtos.responses.images.AddImageResponse;
import java4a.odev.services.dtos.responses.images.ListImageResponse;
import java4a.odev.services.dtos.responses.images.UpdateImageResponse;


import java4a.odev.services.mappers.ImageMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;

    @Override
    public List<ListImageResponse> getByProductId(int productId)
    {
        productShouldExist(productId);
        List<Image> images = imageRepository.findByProductId(productId);
        return ImageMapper.INSTANCE.listResponseFromImage(images);
    }

    @Override
    public ListImageResponse getById(int id) {
        Image image = getImageById(id);
        return ImageMapper.INSTANCE.listImageResponse(image);
    }

    @Override
    public AddImageResponse add(AddImageRequest request) {
        Image image = ImageMapper.INSTANCE.imageFromAddRequest(request);
        image = imageRepository.save(image);
        return ImageMapper.INSTANCE.addResponseFromImage(image);
    }
    @Override
    public UpdateImageResponse update(UpdateImageRequest request) {
        getImageById(request.getId());
        Image updatedImage = ImageMapper.INSTANCE.imageFromUpdateRequest(request);
        updatedImage = imageRepository.save(updatedImage);

        return ImageMapper.INSTANCE.updateResponseFromImage(updatedImage);
    }

    @Override
    public void delete(int id) {
        imageRepository.deleteById(id);
    }

    private Image getImageById(int id) {
        return imageRepository.findById(id).orElseThrow(() -> new BusinessException(id + "ID'sine sahip bir görsel bulunamadı."));
    }

    private void productShouldExist(int productId) {
        imageRepository.findById(productId).orElseThrow(() -> new BusinessException(productId + "ID'sine sahip bir ürün bulunamadı."));
    }
}
