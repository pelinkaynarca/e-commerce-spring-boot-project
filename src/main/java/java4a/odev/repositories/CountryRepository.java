package java4a.odev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java4a.odev.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
