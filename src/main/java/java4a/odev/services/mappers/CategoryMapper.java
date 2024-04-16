package java4a.odev.services.mappers;

import java4a.odev.entities.Category;
import java4a.odev.services.dtos.requests.categories.AddCategoryRequest;
import java4a.odev.services.dtos.requests.categories.UpdateCategoryRequest;
import java4a.odev.services.dtos.responses.categories.AddCategoryResponse;
import java4a.odev.services.dtos.responses.categories.ListCategoryResponse;
import java4a.odev.services.dtos.responses.categories.UpdateCategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "parentId", source = "category.parent.id")
    @Mapping(target = "modifiedAt", source = "category.modifiedAt")
    ListCategoryResponse listResponseFromCategory(Category category);

    List<ListCategoryResponse> toListResponseListFromCategoryList(List<Category> categories);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "parent", source = "parentCategory")
    Category categoryFromAddRequest(AddCategoryRequest request, Category parentCategory);

    @Mapping(target = "parentId", source = "parent.id")
    AddCategoryResponse addResponseCategory(Category category);

    @Mapping(target = "id", source = "request.id")
    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "parent.id", source = "request.parentId")
    Category categoryFromUpdateRequest(UpdateCategoryRequest request, Category existingCategory);

    @Mapping(target = "id", source = "category.id")
    @Mapping(target = "name", source = "category.name")
    @Mapping(target = "parentId", source = "category.parent.id")
    UpdateCategoryResponse updateResponseFromCategory(Category category);
}

