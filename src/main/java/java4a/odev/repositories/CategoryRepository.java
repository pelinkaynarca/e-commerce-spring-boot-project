package java4a.odev.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java4a.odev.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	Optional<Category> findByNameIgnoreCase(String name);

	List<Category> findByNameLikeIgnoreCase(String name);

	/**
	 * Verilen kategorinin alt kategorilerini listeler.
	 * 
	 * @param parentId
	 * @return alt kategoriler
	 */
	@Query(value = "select c from Category c where c.category.id in (:parentId)")
	List<Category> findByParentId(@Param("parentId") Optional<Integer> parentId);
//	List<Category> findByCategory(Category category);
}
