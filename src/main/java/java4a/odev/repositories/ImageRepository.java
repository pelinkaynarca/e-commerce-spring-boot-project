package java4a.odev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java4a.odev.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

}
