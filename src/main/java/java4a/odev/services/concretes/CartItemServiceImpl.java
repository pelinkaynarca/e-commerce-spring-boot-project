package java4a.odev.services.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import java4a.odev.core.utils.exceptions.types.BusinessException;
import java4a.odev.entities.CartItem;
import java4a.odev.entities.Product;
import java4a.odev.repositories.CartItemRepository;
import java4a.odev.repositories.ProductRepository;
import java4a.odev.services.abstracts.CartItemService;
import java4a.odev.services.dtos.requests.cartitems.AddCartItemsRequest;
import java4a.odev.services.dtos.requests.cartitems.UpdateCartItemsRequest;
import java4a.odev.services.dtos.responses.cartitems.AddCartItemResponse;
import java4a.odev.services.dtos.responses.cartitems.ListCartItemResponse;
import java4a.odev.services.dtos.responses.cartitems.UpdateCartItemResponse;
import java4a.odev.services.mappers.CartItemMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartItemServiceImpl implements CartItemService {

	private CartItemRepository cartItemRepository;
	private ProductRepository productRepository;

	@Override
	public List<ListCartItemResponse> getAll() {
		List<CartItem> cartItems = cartItemRepository.findAll();
		List<ListCartItemResponse> listCartItemResponses = new ArrayList<ListCartItemResponse>();
		for (CartItem cartItem : cartItems) {
			listCartItemResponses.add(CartItemMapper.INSTANCE.listResponseFromCartItem(cartItem));
		}
		return listCartItemResponses;
	}

	@Override
	public ListCartItemResponse getById(int id) {
		CartItem cartItem = cartItemRepository.findById(id)
				.orElseThrow(() -> new BusinessException("Sepet ürünü bulunamadı."));
		return CartItemMapper.INSTANCE.listResponseFromCartItem(cartItem);
	}

	@Override
	public AddCartItemResponse add(AddCartItemsRequest request) {
		productMustBeInStockBeforeAddingToUserCart(request.getProductId(), request.getUserId(), request.getQuantity());
		CartItem cartItem = CartItemMapper.INSTANCE.cartItemFromAddRequest(request);

		CartItem savedCartItem = cartItemRepository.save(cartItem);
		return CartItemMapper.INSTANCE.addResponseFromCartItem(savedCartItem);
	}

	@Override
	public UpdateCartItemResponse update(UpdateCartItemsRequest request) {
		productShouldExistAndMustBeInStock(request.getProductId(), request.getQuantity());
		CartItem cartItemToBeSaved = CartItemMapper.INSTANCE.cartItemFromUpdateRequest(request);
		CartItem cartItemInDB = cartItemRepository.findByUserIdAndProductId(request.getUserId(), request.getProductId())
				.orElseThrow();
		cartItemToBeSaved.setId(cartItemInDB.getId());
		CartItem savedCartItem = cartItemRepository.save(cartItemToBeSaved);
		return CartItemMapper.INSTANCE.updateResponseFromCartItem(savedCartItem);
	}

	@Override
	public void delete(int id) {
		cartItemRepository.deleteById(id);
	}

	/**
	 * Sepete eklemeden önce stok kontrolü yapar. Kullanıcının aynı ürünü daha önce
	 * sepete eklemiş olma durumunu da hesaba katar.
	 * 
	 * @param productId
	 * @param userId
	 * @param requestedQuantity
	 */
	private void productMustBeInStockBeforeAddingToUserCart(int productId, int userId, int requestedQuantity) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new BusinessException(productId + " id'li ürün bulunamadı."));
		CartItem cartItem = cartItemRepository.findByUserIdAndProductId(userId, productId).orElse(null);
		boolean throwException = false;
		if (cartItem == null) {// Stok kontrolü yap.
			if (product.getStockQuantity() < requestedQuantity) {
				throwException = true;
			}
		} else if (product.getStockQuantity() < (requestedQuantity + cartItem.getQuantity())) {
			throwException = true;
		}
		if (throwException)
			throw new BusinessException(product.getName() + " isimli üründen stokta yeterli miktarda bulunmamaktadır.");
	}

	private void productShouldExistAndMustBeInStock(int productId, int requestedQuantity) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new BusinessException(productId + " id'li ürün bulunamadı."));
		if (product.getStockQuantity() < requestedQuantity) {
			throw new BusinessException(product.getName() + " isimli üründen stokta yeterli miktarda bulunmamaktadır.");
		}
	}

}
