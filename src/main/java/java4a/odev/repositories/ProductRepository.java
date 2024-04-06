package java4a.odev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java4a.odev.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
