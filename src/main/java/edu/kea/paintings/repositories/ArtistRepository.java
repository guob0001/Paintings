package edu.kea.paintings.repositories;

import edu.kea.paintings.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {


}
