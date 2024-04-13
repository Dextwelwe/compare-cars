package com.dextwelwe.carcomparaison.repository;
import com.dextwelwe.carcomparaison.model.Voiture.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long> {
    @Query("select distinct e.marque from Voiture e")
    List<String> getListeMarques();
    @Query("select distinct e.modele from Voiture e where e.marque =:marque")
    List<String> getListOfModels(String marque);
    @Query("select distinct e.annee from Voiture e where e.marque=:marque and e.modele = :modele")
    List<String> getListOfModelYear(String marque, String modele);
    @Query("select distinct e.version from Voiture e where e.marque=:marque and e.modele =:modele and e.annee=:annee")
    List<String> findAllTrims(String marque, String modele, String annee);
    Voiture findByModeleAndVersion(String modele, String version);
    @Query("select e.id from Voiture e where e.marque=:marque and e.modele =:modele and e.annee=:annee and e.version =:version")
    long findId(String marque, String modele, String annee, String version);
    Optional<Voiture> findById(Long id);
}
