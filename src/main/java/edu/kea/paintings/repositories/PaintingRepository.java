package edu.kea.paintings.repositories;

import edu.kea.paintings.models.Painting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaintingRepository extends JpaRepository<Painting, Long> {
}
