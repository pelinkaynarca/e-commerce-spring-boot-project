package java4a.odev.services.concretes;

import java4a.odev.core.utils.exceptions.types.BusinessException;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public List<ListCategoryResponse> getAll() {
        List<Category> rootCategories = categoryRepository.findRootCategories();
        return rootCategories.stream()
                .map(CategoryMapper.INSTANCE::listResponseFromCategory)
                .collect(Collectors.toList());
    }

    @Override
    public ListCategoryResponse getById(int id) {
        Category category = getCategoryById(id);
        return CategoryMapper.INSTANCE.listResponseFromCategory(category);
    }

    @Override
    public AddCategoryResponse add(AddCategoryRequest request) {
        categoryWithSameNameShouldNotExist(request.getName());
        Category parentCategory = null;

        if (request.getParentId() != null) {
            parentCategory = getParentCategoryById(request.getParentId());
        }

        Category newCategory = CategoryMapper.INSTANCE.categoryFromAddRequest(request, parentCategory);

        Category savedCategory = categoryRepository.save(newCategory);

        return CategoryMapper.INSTANCE.addResponseCategory(savedCategory);
    }

    @Override
    public UpdateCategoryResponse update(UpdateCategoryRequest request) {
        categoryWithSameNameShouldNotExist(request.getName());
        Category existingCategory = getCategoryById(request.getId());

        Category parentCategory = null;
        if (request.getParentId() != null) {
            parentCategory = getParentCategoryById(request.getParentId());
        }

        existingCategory.setParent(parentCategory);

        Category updatedCategory = CategoryMapper.INSTANCE.categoryFromUpdateRequest(request, existingCategory);
        updatedCategory.setModifiedAt(LocalDateTime.now());
        Category savedCategory = categoryRepository.save(updatedCategory);

        return CategoryMapper.INSTANCE.updateResponseFromCategory(savedCategory);
    }

    @Override
    public void delete(int id) {
        Category category = getCategoryById(id);
        categoryRepository.delete(category);
    }

    private Category getCategoryById(int id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new BusinessException("ID'si " + id + " olan kategori bulunamadı."));
    }

    private Category getParentCategoryById(Integer parentId) {
        return categoryRepository.findById(parentId)
                .orElseThrow(() -> new BusinessException("ID'si " + parentId + " olan üst kategori bulunamadı."));
    }
    private void categoryWithSameNameShouldNotExist(String name) {
        Optional<Category> categoryWithSameName = categoryRepository.findByNameIgnoreCase(name);

        if(categoryWithSameName.isPresent())
                throw new BusinessException("Aynı isimde bir kategori zaten var");
    }
}
