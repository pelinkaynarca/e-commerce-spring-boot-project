package java4a.odev.services.abstracts;

import java4a.odev.entities.Category;
import java4a.odev.services.dtos.requests.categories.AddCategoryRequest;
import java4a.odev.services.dtos.requests.categories.UpdateCategoryRequest;
import java4a.odev.services.dtos.responses.categories.AddCategoryResponse;
import java4a.odev.services.dtos.responses.categories.ListCategoryResponse;
import java4a.odev.services.dtos.responses.categories.UpdateCategoryResponse;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<ListCategoryResponse> getAll();
    ListCategoryResponse getById(int id);
    AddCategoryResponse add(AddCategoryRequest request);
    UpdateCategoryResponse update(UpdateCategoryRequest request);
    void delete(int id);
    List<Category> findByParentId(Optional<Integer> parentId);

}
