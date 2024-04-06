package java4a.odev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java4a.odev.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
