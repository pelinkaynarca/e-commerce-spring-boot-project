package java4a.odev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java4a.odev.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
