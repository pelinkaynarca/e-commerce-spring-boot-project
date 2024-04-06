package java4a.odev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java4a.odev.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
