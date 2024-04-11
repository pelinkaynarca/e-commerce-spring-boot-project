package java4a.odev.services.abstracts;

import java4a.odev.services.dtos.requests.products.AddProductRequest;
import java4a.odev.services.dtos.requests.products.UpdateProductRequest;
import java4a.odev.services.dtos.responses.products.AddProductResponse;
import java4a.odev.services.dtos.responses.products.ListProductResponse;
import java4a.odev.services.dtos.responses.products.UpdateProductResponse;

import java.util.List;

public interface ProductService {
    List<ListProductResponse> getAll();
    ListProductResponse getById(int id);
    AddProductResponse add(AddProductRequest request);
    UpdateProductResponse update(UpdateProductRequest request);
    void delete(int id);
    List<ListProductResponse> getByNameContainingIgnoreCase(String name);
    List<ListProductResponse> getByUnitPriceBetween(double p1, double p2);
    List<ListProductResponse> getByCategoryId(int categoryId);
    List<ListProductResponse> getByCreatedAtDesc(int limit);
    List<ListProductResponse> getBestsellersByQuantity(int limit);
}
