package java4a.odev.services.concretes;

import java4a.odev.entities.Product;
import java4a.odev.repositories.ProductRepository;
import java4a.odev.services.abstracts.ProductService;
import java4a.odev.services.dtos.requests.products.AddProductRequest;
import java4a.odev.services.dtos.requests.products.UpdateProductRequest;
import java4a.odev.services.dtos.responses.products.AddProductResponse;
import java4a.odev.services.dtos.responses.products.ListProductResponse;
import java4a.odev.services.dtos.responses.products.UpdateProductResponse;
import java4a.odev.services.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;


    @Override
    public List<ListProductResponse> getAll() {
        return null;
    }

    @Override
    public ListProductResponse getById(int id) {
        return null;
    }

    @Override
    public AddProductResponse add(AddProductRequest request) {
        Product product = ProductMapper.INSTANCE.productFromAddRequest(request);
        Product savedProduct = productRepository.save(product);

        AddProductResponse addProductResponse = ProductMapper.INSTANCE.addResponseFromProduct(savedProduct);

        return addProductResponse;
    }

    @Override
    public UpdateProductResponse update(UpdateProductRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<ListProductResponse> getByNameLikeIgnoreCase(String name) {
        return null;
    }

    @Override
    public List<ListProductResponse> getByUnitPriceBetween(double p1, double p2) {
        return null;
    }

    @Override
    public List<ListProductResponse> getByCategoryId(int categoryId) {
        return null;
    }

    @Override
    public List<ListProductResponse> getByCreatedAtDesc(int limit) {
        return null;
    }

    @Override
    public List<ListProductResponse> getBestsellersByQuantity(int limit) {
        return null;
    }
}