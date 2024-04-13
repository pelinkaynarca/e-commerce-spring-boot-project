package java4a.odev.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import java4a.odev.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmailIgnoreCase(String email);

	Optional<User> findByUsernameIgnoreCase(String username);
}
