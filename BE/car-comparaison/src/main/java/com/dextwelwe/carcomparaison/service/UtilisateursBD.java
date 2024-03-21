package com.dextwelwe.carcomparaison.service;
import com.dextwelwe.carcomparaison.model.Users.Gestionnaire;
import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
import com.dextwelwe.carcomparaison.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
@Service
public class UtilisateursBD implements CommandLineRunner {
    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public void run(String... args) throws Exception {
        createGestionnaire();
    }
    public void createGestionnaire() throws Exception {
        Gestionnaire gestionnaire = new Gestionnaire(1,"Danil","Moskalenko");
        Utilisateur utilisateur = new Utilisateur(2, "Dex@gmail.com", "Daniel", "Moss", new ArrayList<>(), "nope");
        Utilisateur utilisateur2 = new Utilisateur(3, "Dex123@gmail.com", "Daniel123", "Moss123", new ArrayList<>(), "nope123");
        utilisateurService.saveUtilisateur(gestionnaire);
        utilisateurService.saveUtilisateur(utilisateur);
        utilisateurService.saveUtilisateur(utilisateur2);
        System.out.println("created");

    }
}