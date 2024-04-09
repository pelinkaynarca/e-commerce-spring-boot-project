package java4a.odev.controllers;

import jakarta.validation.Valid;

import java4a.odev.services.abstracts.CategoryService;
import java4a.odev.services.dtos.requests.categories.AddCategoryRequest;
import java4a.odev.services.dtos.requests.categories.UpdateCategoryRequest;
import java4a.odev.services.dtos.responses.categories.AddCategoryResponse;
import java4a.odev.services.dtos.responses.categories.ListCategoryResponse;
import java4a.odev.services.dtos.responses.categories.UpdateCategoryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private CategoryService categoryService;

    @GetMapping("/get-all")
    public List<ListCategoryResponse> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public ListCategoryResponse getById(@PathVariable int id){
        return categoryService.getById(id);
    }

    @PostMapping("/create-category")
    @ResponseStatus(HttpStatus.CREATED)
    public AddCategoryResponse add(@RequestBody @Valid AddCategoryRequest request) {
        return categoryService.add(request);
    }

    @PutMapping("/update-category")
    public UpdateCategoryResponse update(@RequestBody @Valid UpdateCategoryRequest request) {
        return categoryService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryService.delete(id);
    }

    @GetMapping("/get-parent")
    public List<ListCategoryResponse> getByParentId(@RequestParam Integer parentId) {
        return categoryService.getByParentId(parentId);
    }
}
