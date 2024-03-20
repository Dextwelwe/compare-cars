package com.dextwelwe.carcomparaison.repository;
import com.dextwelwe.carcomparaison.model.Users.Compte;
import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UtilisateurRepository extends JpaRepository<Compte, Long> {
    Utilisateur findByNomUtilisateur(String nomUtilisateur);
}
