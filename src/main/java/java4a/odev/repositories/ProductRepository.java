package java4a.odev.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java4a.odev.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	Optional<Product> findByName(String name);
	
	Optional<Product> findByNameIgnoreCase(String name);

	List<Product> findByNameContainingIgnoreCase(String name);

	/**
	 * Fiyat aralığına göre listeler.
	 * 
	 * @param p1
	 * @param p2
	 * @return ürün listesi
	 */
	List<Product> findByUnitPriceBetween(double p1, double p2);

	/**
	 * Verilen kategorideki ürünleri listeler.
	 * 
	 * @param categoryId
	 * @return ürün listesi
	 */
	@Query("select p from Product p where p.category.id = :categoryId")
	List<Product> findByCategoryId(@Param("categoryId") int categoryId);

	/**
	 * Yeni eklenen ürünleri listeler.
	 * 
	 * @param limit listelenecek ürün sayısı
	 * @return ürün listesi
	 */
	@Query("select p from Product p order by p.createdAt desc limit :limit")
	List<Product> findByCreatedAtDesc(@Param("limit") int limit);

	/**
	 * Satış sayısına göre en çok satan ürünleri listeler
	 * 
	 * @param limit listelenecek ürün sayısı
	 * @return ürün listesi
	 */
	@Query(value = "SELECT p.* FROM products p" + " JOIN order_items oi ON p.id = oi.product_id" + " GROUP BY p.id"
			+ " ORDER BY SUM(oi.quantity) DESC" + " LIMIT :limit", nativeQuery = true)
	List<Product> findBestsellersByQuantity(@Param("limit") int limit);

}
