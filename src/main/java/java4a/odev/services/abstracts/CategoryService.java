package java4a.odev.services.abstracts;

import java4a.odev.services.dtos.requests.categories.AddCategoryRequest;
import java4a.odev.services.dtos.requests.categories.UpdateCategoryRequest;
import java4a.odev.services.dtos.responses.categories.AddCategoryResponse;
import java4a.odev.services.dtos.responses.categories.ListCategoryResponse;
import java4a.odev.services.dtos.responses.categories.UpdateCategoryResponse;

import java.util.List;

public interface CategoryService {
    List<ListCategoryResponse> getAll();
    ListCategoryResponse getById(int id);
    AddCategoryResponse add(AddCategoryRequest request);
    UpdateCategoryResponse update(UpdateCategoryRequest request);
    void delete(int id);
}
