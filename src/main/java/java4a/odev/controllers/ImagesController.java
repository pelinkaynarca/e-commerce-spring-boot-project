package java4a.odev.controllers;

import jakarta.validation.Valid;

import java4a.odev.services.abstracts.ImageService;
import java4a.odev.services.dtos.requests.images.AddImageRequest;
import java4a.odev.services.dtos.requests.images.UpdateImageRequest;
import java4a.odev.services.dtos.responses.images.AddImageResponse;
import java4a.odev.services.dtos.responses.images.ListImageResponse;
import java4a.odev.services.dtos.responses.images.UpdateImageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/images")
@AllArgsConstructor
public class ImagesController {
    private ImageService imageService;


    @GetMapping("/{productId}")
    public List<ListImageResponse> getById(@PathVariable("productId") int productId){
        return imageService.getByProductId(productId);
    }

    @PostMapping("/create-image")
    @ResponseStatus(HttpStatus.CREATED)
    public AddImageResponse add(@RequestBody @Valid AddImageRequest request) {
        return imageService.add(request);
    }

    @PutMapping("/update-image")
    public UpdateImageResponse update(@RequestBody @Valid UpdateImageRequest request) {
        return imageService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        imageService.delete(id);
    }
}

