package java4a.odev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java4a.odev.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
