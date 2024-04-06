package java4a.odev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java4a.odev.entities.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}
