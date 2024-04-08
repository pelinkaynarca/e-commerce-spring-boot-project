package java4a.odev.services.abstracts;

import java4a.odev.services.dtos.requests.images.AddImageRequest;
import java4a.odev.services.dtos.requests.images.UpdateImageRequest;
import java4a.odev.services.dtos.responses.images.AddImageResponse;
import java4a.odev.services.dtos.responses.images.ListImageResponse;
import java4a.odev.services.dtos.responses.images.UpdateImageResponse;

import java.util.List;

public interface ImageService {
    List<ListImageResponse> getAll();
    ListImageResponse getById(int id);
    AddImageResponse add(AddImageRequest request);
    UpdateImageResponse update(UpdateImageRequest request);
    void delete(int id);
}
