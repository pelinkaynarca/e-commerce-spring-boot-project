package java4a.odev.controllers;

import io.swagger.annotations.Api;
import jakarta.validation.Valid;

import java4a.odev.services.abstracts.ImageService;
import java4a.odev.services.dtos.requests.images.AddImageRequest;
import java4a.odev.services.dtos.requests.images.UpdateImageRequest;
import java4a.odev.services.dtos.responses.images.AddImageResponse;
import java4a.odev.services.dtos.responses.images.ListImageResponse;
import java4a.odev.services.dtos.responses.images.UpdateImageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")

public class ImagesController {
    private ImageService imageService;

    @GetMapping("/getAll")
    public List<ListImageResponse> getAll(){
        return imageService.getAll();
    }

    @GetMapping("/{id}")
    public ListImageResponse getById(@PathVariable int id){
        return imageService.getById(id);
    }

    @PostMapping("/createImage")
    @ResponseStatus(HttpStatus.CREATED)
    public AddImageResponse add(@RequestBody @Valid AddImageRequest request) {
        return imageService.add(request);
    }

    @PutMapping("/updateImage")
    public UpdateImageResponse update(@RequestBody @Valid UpdateImageRequest request) {
        return imageService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        imageService.delete(id);
    }
}

