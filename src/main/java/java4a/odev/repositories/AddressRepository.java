package java4a.odev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java4a.odev.entities.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findAllByUserId(int userId);
}
