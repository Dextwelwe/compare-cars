package com.dextwelwe.carcomparaison.repository;
import com.dextwelwe.carcomparaison.model.Users.Compte;
import com.dextwelwe.carcomparaison.model.Users.Gestionnaire;
import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByNomUtilisateur(String nomUtilisateur);
    Utilisateur findByNomUtilisateurOrEmail(String nomUtilisateur, String email);
    @Query("SELECT g FROM Gestionnaire g WHERE g.nomUtilisateur = :nomUtilisateur")
    Gestionnaire findGestionnaireByNomUtilisateur(String nomUtilisateur);
    @Query("SELECT p.preferences from Utilisateur p where p.nomUtilisateur = :username")
    String getUserPreferences(String username);
}
