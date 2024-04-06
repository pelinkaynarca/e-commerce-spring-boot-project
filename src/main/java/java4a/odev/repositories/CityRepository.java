package java4a.odev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java4a.odev.entities.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
