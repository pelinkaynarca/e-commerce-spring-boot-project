package java4a.odev.services.concretes;

import java4a.odev.entities.Category;
import java4a.odev.repositories.CategoryRepository;
import java4a.odev.services.abstracts.CategoryService;
import java4a.odev.services.dtos.requests.categories.AddCategoryRequest;
import java4a.odev.services.dtos.requests.categories.UpdateCategoryRequest;
import java4a.odev.services.dtos.responses.categories.AddCategoryResponse;
import java4a.odev.services.dtos.responses.categories.ListCategoryResponse;
import java4a.odev.services.dtos.responses.categories.UpdateCategoryResponse;
import java4a.odev.services.mappers.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public List<ListCategoryResponse> getAll() {
        List<Category> rootCategories = categoryRepository.findRootCategories();
        return rootCategories.stream()
                .map(CategoryMapper.INSTANCE::mapToCategoryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ListCategoryResponse getById(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        ListCategoryResponse response = CategoryMapper.INSTANCE.mapToCategoryResponse(category);

        return response;
    }

    @Override
    public AddCategoryResponse add(AddCategoryRequest request) {
        Category parentCategory = null;

        if (request.getParentId() != null) {
            parentCategory = categoryRepository.findById(request.getParentId())
                    .orElseThrow(() -> new IllegalArgumentException("Parent category not found with ID: " + request.getParentId()));
        }

        Category newCategory = CategoryMapper.INSTANCE.addCategoryRequestToCategory(request, parentCategory);

        newCategory.setCreatedAt(LocalDateTime.now());

        Category savedCategory = categoryRepository.save(newCategory);

        return CategoryMapper.INSTANCE.categoryToAddCategoryResponse(savedCategory);
    }

    @Override
    public UpdateCategoryResponse update(UpdateCategoryRequest request) {
        Category existingCategory = categoryRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found with ID: " + request.getId()));

        Category updatedCategory = CategoryMapper.INSTANCE.mapUpdateCategoryRequestToCategory(request, existingCategory);

        updatedCategory.setModifiedAt(LocalDateTime.now());
        Category savedCategory = categoryRepository.save(updatedCategory);

        return CategoryMapper.INSTANCE.mapCategoryToUpdateCategoryResponse(savedCategory );
    }

    @Override
    public void delete(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with ID: " + id));
        categoryRepository.delete(category);
    }


}
