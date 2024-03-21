package com.dextwelwe.carcomparaison.service;
import com.dextwelwe.carcomparaison.model.Users.Gestionnaire;
import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
import com.dextwelwe.carcomparaison.model.Voiture.Voiture;
import com.dextwelwe.carcomparaison.repository.UtilisateurRepository;
import com.dextwelwe.carcomparaison.repository.VoitureRepository;
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

    @Autowired
    VoitureRepository voitureRepository;

    @Override
    public void run(String... args) throws Exception {
        createGestionnaire();
    }
    public void createGestionnaire() throws Exception {
        Gestionnaire gestionnaire = new Gestionnaire(1,"Danil","Moskalenko");
        Utilisateur utilisateur = new Utilisateur(2, "Dex@gmail.com", "Daniel", "Moss", new ArrayList<>(), "nope");
        Utilisateur utilisateur2 = new Utilisateur(3, "Dex123@gmail.com", "Daniel123", "Moss123", new ArrayList<>(), "nope123");
        Utilisateur utilisateur3 = new Utilisateur(4, "emailQuoi@hotmail.xz", "Daniel123", "Moss123", new ArrayList<>(), "nope123");
        utilisateurRepository.save(gestionnaire);
        utilisateurService.saveUpdateUtilisateur(utilisateur.toDTO(utilisateur));
        utilisateurService.saveUpdateUtilisateur(utilisateur2.toDTO(utilisateur2));
        utilisateurService.saveUpdateUtilisateur(utilisateur3.toDTO(utilisateur3));

        Voiture voiture = new Voiture(1, "Audi", "2012", "vers1", "a4");
        Voiture voiture2 = new Voiture(2, "Audi", "2012", "vers2", "a4");
        Voiture voiture3 = new Voiture(3, "Toyota", "2012", "1", "Tacoma");
        Voiture voiture4 = new Voiture(4, "Hyundai", "2013", "gt", "Elantra");
        Voiture voiture5 = new Voiture(5, "Audi", "2012", "vers3", "a4");

        voitureRepository.save(voiture);
        voitureRepository.save(voiture2);
        voitureRepository.save(voiture3);
        voitureRepository.save(voiture4);
        voitureRepository.save(voiture5);

        System.out.println("created");
    }
}