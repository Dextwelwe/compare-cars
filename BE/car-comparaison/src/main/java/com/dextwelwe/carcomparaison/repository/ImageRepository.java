package com.dextwelwe.carcomparaison.repository;
import com.dextwelwe.carcomparaison.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByNomDeFichier(String nomDeFichier);

}
