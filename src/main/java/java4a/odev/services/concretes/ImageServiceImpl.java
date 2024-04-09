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


@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;


    @Override
    public ListImageResponse getById(int id) {
        Image images = imageRepository.findById(id).orElseThrow(() -> new RuntimeException("Image not found with id:" + id));
        return ImageMapper.INSTANCE.toListImageResponse(images);
    }

    @Override
    public AddImageResponse add(AddImageRequest request) {
        Image image = ImageMapper.INSTANCE.imageFromAddRequest(request);
        image = imageRepository.save(image);
       return ImageMapper.INSTANCE.addResponseFromImage(image);

    }

    @Override
    public UpdateImageResponse update(UpdateImageRequest request) {
       Image image = imageRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException("Image not found with id: " + request.getId()));
       image = imageRepository.save(image);

        return ImageMapper.INSTANCE.updateImageResponseFromImage(image);
    }

    @Override
    public void delete(int id) {

        Image image = imageRepository.findById(id).orElseThrow();
        imageRepository.delete(image);
    }
}
