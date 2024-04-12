package java4a.odev.repositories;

import java4a.odev.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java4a.odev.entities.City;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Integer> {
    Optional<City> findByNameIgnoreCase(String name);
}
