package java4a.odev.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java4a.odev.entities.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

	Optional<CartItem> findByUserIdAndProductId(@Param("userId") int userId, @Param("productId") int productId);
	
}
