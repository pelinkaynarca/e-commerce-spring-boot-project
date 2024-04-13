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
    @Mapping(source = "category.modifiedAt", target = "modifiedAt")
    ListCategoryResponse mapToCategoryResponse(Category category);

    List<ListCategoryResponse> mapListToCategoryResponseList(List<Category> categories);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "parent", source = "parentCategory")
    Category addCategoryRequestToCategory(AddCategoryRequest request, Category parentCategory);

    @Mapping(target = "parentId", source = "parent.id")
    AddCategoryResponse categoryToAddCategoryResponse(Category category);

    @Mapping(target = "id", source = "request.id")
    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "parent.id", source = "request.parentId")
    Category mapUpdateCategoryRequestToCategory(UpdateCategoryRequest request, Category existingCategory);

    @Mapping(source = "category.id", target = "id")
    @Mapping(source = "category.name", target = "name")
    @Mapping(source = "category.parent.id", target = "parentId")
    UpdateCategoryResponse mapCategoryToUpdateCategoryResponse(Category category);
}

