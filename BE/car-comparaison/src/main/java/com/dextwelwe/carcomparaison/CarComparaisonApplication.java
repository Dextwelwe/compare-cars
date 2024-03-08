package com.dextwelwe.carcomparaison;

import com.dextwelwe.carcomparaison.model.Compte;
import com.dextwelwe.carcomparaison.model.Gestionnaire;
import com.dextwelwe.carcomparaison.repository.UtilisateurRepository;
import com.dextwelwe.carcomparaison.service.UtilisateurService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class CarComparaisonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarComparaisonApplication.class, args);
	}

}
