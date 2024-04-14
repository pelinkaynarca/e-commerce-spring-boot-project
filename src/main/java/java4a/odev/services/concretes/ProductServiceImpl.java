package java4a.odev.services.concretes;

import java4a.odev.core.utils.exceptions.types.BusinessException;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	@Override
	public List<ListProductResponse> getAll() {
		List<Product> productList = productRepository.findAll();
		List<ListProductResponse> productResponseList = new ArrayList<ListProductResponse>();
		for (Product product : productList) {
			productResponseList.add(ProductMapper.INSTANCE.listResponseFromProduct(product));
		}
		return productResponseList;
	}

	@Override
	public ListProductResponse getById(int id) {
		Product product = productRepository.findById(id).orElse(null);
		return ProductMapper.INSTANCE.listResponseFromProduct(product);
	}

	@Override
	public AddProductResponse add(AddProductRequest request) {
		productWithSameNameShouldNotExist(request.getName());
		Product product = ProductMapper.INSTANCE.productFromAddRequest(request);
		Product savedProduct = productRepository.save(product);
		AddProductResponse addProductResponse = ProductMapper.INSTANCE.addResponseFromProduct(savedProduct);
		return addProductResponse;
	}

	@Override
	public UpdateProductResponse update(UpdateProductRequest request) {
		productWithSameNameShouldNotExist(request.getName());
		Product product = ProductMapper.INSTANCE.productFromUpdateRequest(request);
		product.setModifiedAt(LocalDateTime.now());
		Product savedProduct = productRepository.save(product);
		return ProductMapper.INSTANCE.updateResponseFromProduct(savedProduct);
	}

	@Override
	public void delete(int id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<ListProductResponse> getByNameContainingIgnoreCase(String name) {
		List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
		List<ListProductResponse> listProductResponses = new ArrayList<ListProductResponse>();
		for (Product product : products) {
			listProductResponses.add(ProductMapper.INSTANCE.listResponseFromProduct(product));
		}
		return listProductResponses;
	}

	@Override
	public List<ListProductResponse> getByUnitPriceBetween(double p1, double p2) {
		List<Product> products = productRepository.findByUnitPriceBetween(p1, p2);
		List<ListProductResponse> listProductResponses = new ArrayList<ListProductResponse>();
		for (Product product : products) {
			listProductResponses.add(ProductMapper.INSTANCE.listResponseFromProduct(product));
		}
		return listProductResponses;
	}

	@Override
	public List<ListProductResponse> getByCategoryId(int categoryId) {
		List<Product> products = productRepository.findByCategoryId(categoryId);
		List<ListProductResponse> listProductResponses = new ArrayList<ListProductResponse>();
		for (Product product : products) {
			listProductResponses.add(ProductMapper.INSTANCE.listResponseFromProduct(product));
		}
		return listProductResponses;
	}

	@Override
	public List<ListProductResponse> getByCreatedAtDesc(int limit) {
		List<Product> products = productRepository.findByCreatedAtDesc(limit);
		List<ListProductResponse> listProductResponses = new ArrayList<ListProductResponse>();
		for (Product product : products) {
			listProductResponses.add(ProductMapper.INSTANCE.listResponseFromProduct(product));
		}
		return listProductResponses;
	}

	@Override
	public List<ListProductResponse> getBestsellersByQuantity(int limit) {
		List<Product> products = productRepository.findBestsellersByQuantity(limit);
		List<ListProductResponse> listProductResponses = new ArrayList<ListProductResponse>();
		for (Product product : products) {
			listProductResponses.add(ProductMapper.INSTANCE.listResponseFromProduct(product));
		}
		return listProductResponses;
	}

	private void productWithSameNameShouldNotExist(String name) {
		Optional<Product> productWithSameName = productRepository.findByNameIgnoreCase(name);

		if (productWithSameName.isPresent())
			throw new BusinessException("Aynı isimde bir ürün zaten var");
	}
}