package java4a.odev.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java4a.odev.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Query("SELECT c FROM Category c WHERE c.parent IS NULL")
	List<Category> findRootCategories();

	Optional<Category>  findByNameIgnoreCase(String name);

	Optional<Category> findById(int id);
	
	/**
	 * Verilen kategorinin alt kategorilerini listeler.
	 * 
	 * @param parentId
	 * @return alt kategoriler
	 */
	@Query(value = "select c from Category c where c.parent.id in (:parentId)")
	List<Category> findByParentId(@Param("parentId") Integer parentId);
}
