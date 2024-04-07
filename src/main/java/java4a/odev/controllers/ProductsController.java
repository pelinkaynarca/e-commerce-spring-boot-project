package java4a.odev.controllers;

import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import java4a.odev.services.abstracts.ProductService;
import java4a.odev.services.dtos.requests.products.AddProductRequest;
import java4a.odev.services.dtos.requests.products.UpdateProductRequest;
import java4a.odev.services.dtos.responses.products.AddProductResponse;
import java4a.odev.services.dtos.responses.products.ListProductResponse;
import java4a.odev.services.dtos.responses.products.UpdateProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")

public class ProductsController {
    private ProductService productService;

    @GetMapping("/getAll")
    public List<ListProductResponse> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public ListProductResponse getById(@PathVariable int id){
        return productService.getById(id);
    }

    @PostMapping("/createProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public AddProductResponse add(@RequestBody @Valid AddProductRequest request) {
        return productService.add(request);
    }

    @PutMapping("/updateProduct")
    public UpdateProductResponse update(@RequestBody @Valid UpdateProductRequest request) {
        return productService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }
    @GetMapping("/searchByName")
    public List<ListProductResponse> findByName(@RequestParam String name) {
        return productService.getByNameLikeIgnoreCase(name);
    }

    @GetMapping("/searchByPriceRange")
    public List<ListProductResponse> findByPriceRange(@RequestParam double p1, @RequestParam double p2) {
        return productService.getByUnitPriceBetween(p1, p2);
    }

    @GetMapping("/searchByCategory/{categoryId}")
    public List<ListProductResponse> findByCategory(@PathVariable int categoryId) {
        return productService.getByCategoryId(categoryId);
    }

    @GetMapping("/latestProducts")
    public List<ListProductResponse> getLatestProducts(@RequestParam int limit) {
        return productService.getByCreatedAtDesc(limit);
    }

    @GetMapping("/bestsellers")
    public List<ListProductResponse> getBestsellers(@RequestParam int limit) {
        return productService.getBestsellersByQuantity(limit);
    }
}
