package java4a.odev.services.concretes;

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
    public List<ListImageResponse> getByProductId(int productId) {
        List<Image> image = imageRepository.findAll();
        return ImageMapper.INSTANCE.ListResponseFromImage(image);

    }

    @Override
        public ListImageResponse getById(int id) {
            Image image = imageRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Image not found with id: " + id));
            return ImageMapper.INSTANCE.ListImageResponse(image);
        }

    @Override
    public AddImageResponse add(AddImageRequest request) {
        Image image = ImageMapper.INSTANCE.imageFromAddRequest(request);
        image = imageRepository.save(image);
       return ImageMapper.INSTANCE.addResponseFromImage(image);

    }

    @Override
    public UpdateImageResponse update(UpdateImageRequest request) {
        imageRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Country not found with id: " + request.getId()));
        Image image;
       image = ImageMapper.INSTANCE.imageFromUpdateRequest(request);
       image = imageRepository.save(image);

        UpdateImageResponse updateImageResponse = ImageMapper.INSTANCE.updateResponseFromImage(image);
        return updateImageResponse;
    }

    @Override
    public void delete(int id) {

        Image image = imageRepository.findById(id).orElseThrow();
        imageRepository.delete(image);
    }
}
