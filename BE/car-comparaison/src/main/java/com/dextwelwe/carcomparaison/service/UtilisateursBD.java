package com.dextwelwe.carcomparaison.service;
import com.dextwelwe.carcomparaison.model.Image;
import com.dextwelwe.carcomparaison.model.Users.Gestionnaire;
import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
import com.dextwelwe.carcomparaison.model.Voiture.EnumsVoiture;
import com.dextwelwe.carcomparaison.model.Voiture.Voiture;
import com.dextwelwe.carcomparaison.repository.ImageRepository;
import com.dextwelwe.carcomparaison.repository.UtilisateurRepository;
import com.dextwelwe.carcomparaison.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UtilisateursBD implements CommandLineRunner {
    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    VoitureRepository voitureRepository;
    @Autowired
    VoitureService voitureService;
    @Autowired
    ImageRepository imageRepository;

    @Override
    public void run(String... args) throws Exception {
        createGestionnaire();
    }
    public void createGestionnaire() throws Exception {
        Gestionnaire gestionnaire = new Gestionnaire(1,"Danil","Moskalenko");
        Utilisateur utilisateur = new Utilisateur(2, "dex@gmail.com", "Daniel", "mossmoss", new ArrayList<>(), "nope");
        Utilisateur utilisateur2 = new Utilisateur(1, "Dex123@gmail.com", "Daniel123", "mossmoss", new ArrayList<>(), "nope123");
        utilisateurRepository.save(utilisateur2);
        utilisateurRepository.save(utilisateur);
        //utilisateurService.saveUtilisateur(utilisateur.toDTO(utilisateur));
        //utilisateurService.saveUtilisateur(utilisateur2.toDTO(utilisateur2));


        List<String> imagePaths = new ArrayList<>();
        File folder = new File("C:/Users/dextw/OneDrive/Desktop/CarComparaison/BE/car-comparaison/src/main/java/com/dextwelwe/carcomparaison/images");
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                System.out.println(file);
                if (file.isFile()) {
                    imagePaths.add(file.getAbsolutePath());
                }
            }
        }


        Image mustang = new Image();
        mustang.setId(1);
        mustang.setType("img");

        mustang.setProprietaire(utilisateur);
        mustang.setNomDeFichier("mustang");
        mustang.setImageData(mustang.imgToByteArray(imagePaths.get(0)));

        Image mustang2 = new Image();
        mustang2.setId(4);
        mustang2.setType("img");

        mustang2.setProprietaire(utilisateur2);
        mustang2.setNomDeFichier("mustang");
        mustang2.setImageData(mustang.imgToByteArray(imagePaths.get(1)));





        Voiture Corolla = new Voiture(1, "Toyota", "2022", "Corolla", "LE","Compact sedan with excellent fuel efficiency.","","", EnumsVoiture.Transmission.Automatic, EnumsVoiture.Motricite.FWD, EnumsVoiture.TypeCarburant.GAS,"Sedan", "1.8L 4-cylinder" , 4 ,"30 mpg", "35 mpg","Backup camera,Lane departure warning", "Silver,Black,White", new ArrayList<>(), new ArrayList<>(), "20000$", "150hp", "124" , "123");
        Voiture Civic = new Voiture(2, "Honda", "2023", "Civic", "Sport", "Sporty compact car with agile handling.","","", EnumsVoiture.Transmission.Manual, EnumsVoiture.Motricite.FWD, EnumsVoiture.TypeCarburant.GAS, "Hatchback", "2.0L 4-cylinder", 5, "32 mpg", "36 mpg", "Apple CarPlay, Android Auto", "Red,Blue,Gray", new ArrayList<>(), new ArrayList<>(), "22000$", "123", "123", "123");
        Voiture ModelS = new Voiture(3, "Tesla", "2024", "Model S", "Long Range", "Luxury electric sedan with cutting-edge technology.","","", EnumsVoiture.Transmission.Electric, EnumsVoiture.Motricite.AWD, EnumsVoiture.TypeCarburant.ELECTRIC, "Sedan", "Dual Motor", 4, "none", "none", "Autopilot,Full self-driving capability", "Black,White,Blue", new ArrayList<>(), new ArrayList<>(), "80000$","123", "123", "123");

        Voiture Mustang = new Voiture(4, "Ford", "2022", "Mustang", "GT", "Iconic American muscle car with powerful V8 engine. The Ford Mustang 2022 is a powerful American muscle car with sleek design, potent engine options, and modern technology. It maintains its classic appeal with aggressive body lines and a refined interior.","", "", EnumsVoiture.Transmission.Manual, EnumsVoiture.Motricite.RWD, EnumsVoiture.TypeCarburant.GAS, "Coupe", "5.0L V8", 2, "20 mpg", "25 mpg", "Track package available", "Yellow,Red,Black", null, new ArrayList<>(), "40000$","123", "123", "123");
        Voiture Mustang22 = new Voiture(10, "Ford", "2023", "Mustang", "GT", "Iconic American muscle car with powerful V8 engine.","","", EnumsVoiture.Transmission.Manual, EnumsVoiture.Motricite.RWD, EnumsVoiture.TypeCarburant.GAS, "Coupe", "5.0L V8", 2, "20 mpg", "25 mpg", "Track package available", "Yellow,Red,Black", null, new ArrayList<>(), "40000$","123", "123", "123");

        Voiture Mustang223 = new Voiture(11, "Ford", "2024", "Mustang2", "GT", "Iconic American muscle car with powerful V8 engine.","","", EnumsVoiture.Transmission.Manual, EnumsVoiture.Motricite.RWD, EnumsVoiture.TypeCarburant.GAS, "Coupe", "5.0L V8", 2, "20 mpg", "25 mpg", "Track package available", "Yellow,Red,Black", new ArrayList<>(), new ArrayList<>(), "40000$","123", "123", "123");
        Voiture voiture5 = new Voiture(5, "BMW", "2022", "3 Series", "330i","Luxury sedan with strong performance and upscale interior","","", EnumsVoiture.Transmission.Manual, EnumsVoiture.Motricite.RWD, EnumsVoiture.TypeCarburant.GAS, "Sedan", "2.0L turbocharged 4-cylinder", 4, "29 mpg", "34 mpg", "Leather upholstery,Navigation system","Black,White,Silver",new ArrayList<>(), new ArrayList<>(), "45000$","123", "123", "123");
        Voiture voiture6 = new Voiture(6, "Audi", "2012", "vers1", "a4");
        Voiture voiture7 = new Voiture(7, "Audi", "2012", "vers2", "a5");
        Voiture voiture8 = new Voiture(8, "Audi", "2018", "autobahn", "rs7");
        Voiture voiture9 = new Voiture(9, "Mazda", "2010", "GT", "3");



        List<Image> mustangList = List.of(mustang);
        List<Image> mustangList2 = List.of(mustang2);
        Mustang.setImages(mustangList);
        Mustang22.setImages(mustangList2);

/*
        voitureRepository.save(Corolla);
        voitureRepository.save(Civic);
        voitureRepository.save(ModelS);

 */
        imageRepository.save(mustang);
        imageRepository.save(mustang2);
        voitureRepository.save(Mustang);
        voitureRepository.save(Mustang22);
        mustang.setVoiture(Mustang);
        mustang2.setVoiture(Mustang22);
        imageRepository.save(mustang);
        imageRepository.save(mustang2);



 /*
        voitureRepository.save(Mustang223);
        voitureRepository.save(voiture5);
        voitureRepository.save(voiture6);
        voitureRepository.save(voiture7);
        voitureRepository.save(voiture8);
        voitureRepository.save(voiture9);
        */



        System.out.println("created");
        System.out.println("----USERS-----");
        System.out.println(utilisateurRepository.findByNomUtilisateur("Daniel"));
        System.out.println("-------");
        System.out.println("---GESTIONNAIRE->");
        System.out.println(utilisateurRepository.findGestionnaireByNomUtilisateur("Danil"));
        System.out.println("---------");
        System.out.println(voitureRepository.findByModeleAndVersion("Corolla", "LE"));
        System.out.println("---------");
        System.out.println(voitureRepository.getListeMarques());
        System.out.println("---------");
        System.out.println(voitureRepository.getListOfModels("Audi"));
        System.out.println("---------");
    }
}