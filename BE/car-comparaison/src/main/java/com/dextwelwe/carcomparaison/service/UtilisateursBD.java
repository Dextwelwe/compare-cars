package com.dextwelwe.carcomparaison.service;
import com.dextwelwe.carcomparaison.model.Compte;
import com.dextwelwe.carcomparaison.model.Gestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class UtilisateursBD implements CommandLineRunner {
    @Autowired
    UtilisateurService u;

    @Override
    public void run(String... args) {
        createGestionnaire();
    }
    public void createGestionnaire(){
        Gestionnaire gestionnaire = new Gestionnaire(3,"s","s");
        Compte c = new Compte(1, "abc", "abc");
        u.saveUtilisateur(c);
        u.saveUtilisateur(gestionnaire);
        System.out.println("created");
    }
}