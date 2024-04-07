package java4a.odev.controllers;

import io.swagger.annotations.Api;
import jakarta.validation.Valid;

import java4a.odev.services.dtos.requests.categories.AddCategoryRequest;
import java4a.odev.services.dtos.requests.categories.UpdateCategoryRequest;
import java4a.odev.services.dtos.responses.categories.AddCategoryResponse;
import java4a.odev.services.dtos.responses.categories.ListCategoryResponse;
import java4a.odev.services.dtos.responses.categories.UpdateCategoryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")

public class CategoriesController {

    private CategoriesController categoryService;

    @GetMapping("/getAll")
    public List<ListCategoryResponse> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public ListCategoryResponse getById(@PathVariable int id){
        return categoryService.getById(id);
    }

    @PostMapping("/createCategory")
    @ResponseStatus(HttpStatus.CREATED)
    public AddCategoryResponse add(@RequestBody @Valid AddCategoryRequest request) {
        return categoryService.add(request);
    }

    @PutMapping("/updateCategory")
    public UpdateCategoryResponse update(@RequestBody @Valid UpdateCategoryRequest request) {
        return categoryService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryService.delete(id);
    }

    @GetMapping("/getByParent")
    public List<ListCategoryResponse> getCategoriesByParentId(@RequestParam Optional<Integer> parentId) {
        return categoryService.getCategoriesByParentId(parentId);
    }
}
