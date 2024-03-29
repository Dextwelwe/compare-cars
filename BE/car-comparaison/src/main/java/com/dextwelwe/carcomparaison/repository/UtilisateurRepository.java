package com.dextwelwe.carcomparaison.repository;
import com.dextwelwe.carcomparaison.model.Users.Compte;
import com.dextwelwe.carcomparaison.model.Users.Gestionnaire;
import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface UtilisateurRepository extends JpaRepository<Compte, Long> {
    Utilisateur findByNomUtilisateur(String nomUtilisateur);
    @Query("SELECT g FROM Gestionnaire g WHERE g.nomUtilisateur = :nomUtilisateur")
    Gestionnaire findGestionnaireByNomUtilisateur(String nomUtilisateur);
}
