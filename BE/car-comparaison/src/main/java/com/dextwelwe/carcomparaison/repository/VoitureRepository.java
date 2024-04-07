package com.dextwelwe.carcomparaison.repository;
import com.dextwelwe.carcomparaison.model.Voiture.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long> {
    @Query("select distinct e.marque from Voiture e")
    List<String> getListeMarques();
    @Query("select distinct e.modele from Voiture e where e.marque =:marque")
    List<String> getListOfModels(String marque);
    @Query("select distinct e.annee from Voiture e where e.marque=:marque and e.modele = :modele")
    List<String> getListOfModelYear(String marque, String modele);
    Voiture findByModeleAndVersion(String modele, String version);

}
