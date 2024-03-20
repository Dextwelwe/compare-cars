package com.dextwelwe.carcomparaison.service;
import com.dextwelwe.carcomparaison.DTO.Users.ConnectionRequest;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTOGet;
import com.dextwelwe.carcomparaison.model.Users.Compte;
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
        Gestionnaire gestionnaire = new Gestionnaire(3,"s","s");
        Compte c = new Compte(1, "abc", "abc");
        Utilisateur usd = new Utilisateur(11, "Dex", "dan", "mdp", null, "nope");
        utilisateurService.saveUtilisateur(c);
        utilisateurService.saveUtilisateur(gestionnaire);
        utilisateurService.saveUtilisateur(usd);
        System.out.println("created");
        ConnectionRequest connectionRequest = new ConnectionRequest();
        connectionRequest.setNomUtilisateur("dan");
        connectionRequest.setMotDePasse("mdp");
        System.out.println(usd.getRevues());
        Utilisateur u = (Utilisateur) utilisateurRepository.findByNomUtilisateur("dan");
        System.out.println(u);
    }
}