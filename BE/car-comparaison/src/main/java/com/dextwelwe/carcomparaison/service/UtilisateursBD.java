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
        Utilisateur utilisateur = new Utilisateur(1, "dex@gmail.com", "Daniel", "mossmoss", new ArrayList<>(), "FUELECONOMYHWY;AUTONOMY;TYPE;TORQUE;POWER;FUELTYPE");
        Utilisateur utilisateur2 = new Utilisateur(2, "Dex123@gmail.com", "Daniel123", "mossmoss", new ArrayList<>(), "nope123");
        Utilisateur utilisateur4 = new Utilisateur(3, "Dex1231@gmail.com", "Daniel1231", "mossmossmo", new ArrayList<>(), "nope123");
        utilisateurRepository.save(utilisateur);
        utilisateurRepository.save(utilisateur2);

        utilisateurRepository.save(utilisateur4);
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

        Image corolla = new Image();
        corolla.setId(5);
        corolla.setType("img");
        corolla.setProprietaire(utilisateur4);
        corolla.setImageData(corolla.imgToByteArray(imagePaths.get(2)));


        String descMustang = "The iconic pony car makes its comeback in 2022, boasting few significant alterations aside from some fresh package options. The standard Mustang retains its turbocharged 2.3-liter four-cylinder engine, while the GT and Mach 1 variants are equipped with a robust 5.0-liter V8. However, the Mustang Shelby GT500 takes performance to unparalleled levels, featuring a supercharged 5.2-liter V8 engine generating an impressive 760 horsepower and 625 pound-feet of torque.";
        String descCorolla = "Toyota has introduced several updates for the 2022 Corolla and Corolla Hatchback. These revisions encompass fresh body paint options, the replacement of the Special Edition with the Nightshade Edition, and the addition of a new JBL audio system featuring eight speakers in the Corolla Hatchback XSE. Most other aspects remain unchanged, including the 1.8-liter and 2.0-liter engines, which deliver 139 and 169 horsepower, respectively. The Corolla Hybrid stands as a more eco-friendly option for those seeking fuel efficiency.";

        Voiture Corolla = new Voiture(1, "Toyota", "2022", "Corolla", "LE",descCorolla,"Solid reliability reputation;Attractive fuel consumption;Surprisingly fun to drive","Small switches on the instrument panel;Reduced rear visibility (Hatchback);Limited space at the rear", EnumsVoiture.Transmission.Automatic, EnumsVoiture.Motricite.FWD, EnumsVoiture.TypeCarburant.GAS,"Sedan", "1,8 l I-4" , 4 ,"8.0 L/100km", "6.0 L/100km","Backup camera,Lane departure warning", "Silver, Black, White", new ArrayList<>(), new ArrayList<>(), "CA$19,450", "139 hp @ 6,100 rpm (104 kW)", "126 lb·ft @ 3,900 rpm (171 N·m)" , "704 km");
        //Voiture Civic = new Voiture(2, "Honda", "2023", "Civic", "Sport", "Sporty compact car with agile handling.","","", EnumsVoiture.Transmission.Manual, EnumsVoiture.Motricite.FWD, EnumsVoiture.TypeCarburant.GAS, "Hatchback", "2.0L 4-cylinder", 5, "32 mpg", "36 mpg", "Apple CarPlay, Android Auto", "Red,Blue,Gray", new ArrayList<>(), new ArrayList<>(), "22000$", "123", "123", "123");
        //Voiture ModelS = new Voiture(3, "Tesla", "2024", "Model S", "Long Range", "Luxury electric sedan with cutting-edge technology.","Very attractive Mach 1 model;Colossal performance (GT500);A blast to drive;Good reliability ","", EnumsVoiture.Transmission.Electric, EnumsVoiture.Motricite.AWD, EnumsVoiture.TypeCarburant.ELECTRIC, "Sedan", "Dual Motor", 4, "none", "none", "Autopilot,Full self-driving capability", "Black,White,Blue", new ArrayList<>(), new ArrayList<>(), "80000$","123", "123", "123");


        Voiture Mustang = new Voiture(4, "Ford", "2022", "Mustang", "EcoBoost FastBack", descMustang,"Very attractive Mach 1 model;Colossal performance (GT500); blast to drive;Good reliability", "Price is going up; Disappointing 4-cylinder engine; Aging model; Layout details (interior)", EnumsVoiture.Transmission.Manual, EnumsVoiture.Motricite.RWD, EnumsVoiture.TypeCarburant.GAS, "Coupe", "5.0L V8", 2, "11.5 L/100km", "8.2 L/100km", "Track package available", "Yellow, Red, Black", null, new ArrayList<>(), "CA$32,295","310 hp @ 5,500 rpm (231 kW)", "350 lb·ft @ 3,000 rpm (475 N·m)", "580 km");
        Voiture MustangGT = new Voiture(10, "Ford", "2023", "Mustang", "GT", descMustang,"Very attractive Mach 1 model;Colossal performance (GT500);A blast to drive;Good reliability","Price is going up; Disappointing 4-cylinder engine; Aging model; Layout details (interior)", EnumsVoiture.Transmission.Manual, EnumsVoiture.Motricite.RWD, EnumsVoiture.TypeCarburant.GAS, "Coupe", "5.0L V8", 2, "20 mpg", "25 mpg", "Track package available", "Yellow,Red,Black", null, new ArrayList<>(), "40000$","123", "123", "123");


        Voiture Mustang223 = new Voiture(11, "Ford", "2024", "Mustang2", "GT", "Iconic American muscle car with powerful V8 engine.","","", EnumsVoiture.Transmission.Manual, EnumsVoiture.Motricite.RWD, EnumsVoiture.TypeCarburant.GAS, "Coupe", "5.0L V8", 2, "20 mpg", "25 mpg", "Track package available", "Yellow,Red,Black", new ArrayList<>(), new ArrayList<>(), "40000$","123", "123", "123");
        Voiture voiture5 = new Voiture(5, "BMW", "2022", "3 Series", "330i","Luxury sedan with strong performance and upscale interior","","", EnumsVoiture.Transmission.Manual, EnumsVoiture.Motricite.RWD, EnumsVoiture.TypeCarburant.GAS, "Sedan", "2.0L turbocharged 4-cylinder", 4, "29 mpg", "34 mpg", "Leather upholstery,Navigation system","Black,White,Silver",new ArrayList<>(), new ArrayList<>(), "45000$","123", "123", "123");
        Voiture voiture6 = new Voiture(6, "Audi", "2012", "vers1", "a4");
        Voiture voiture7 = new Voiture(7, "Audi", "2012", "vers2", "a5");
        Voiture voiture8 = new Voiture(8, "Audi", "2018", "autobahn", "rs7");
        Voiture voiture9 = new Voiture(9, "Mazda", "2010", "GT", "3");



        List<Image> mustangList = List.of(mustang);
        List<Image> mustangList2 = List.of(mustang2);
        List<Image> corollaList = List.of(corolla);
        Mustang.setImages(mustangList);
        MustangGT.setImages(mustangList2);
        Corolla.setImages(corollaList);
/*
        voitureRepository.save(Corolla);
        voitureRepository.save(Civic);
        voitureRepository.save(ModelS);

 */
        imageRepository.save(mustang);
        imageRepository.save(mustang2);
        imageRepository.save(corolla);
        voitureRepository.save(Mustang);
        voitureRepository.save(MustangGT);
        voitureRepository.save(Corolla);
        mustang.setVoiture(MustangGT);
        mustang2.setVoiture(Mustang);
        corolla.setVoiture(Corolla);
        imageRepository.save(mustang);
        imageRepository.save(mustang2);
        imageRepository.save(corolla);



 /*
        voitureRepository.save(Mustang223);
        voitureRepository.save(voiture5);
        voitureRepository.save(voiture6);
        voitureRepository.save(voiture7);
        voitureRepository.save(voiture8);
        voitureRepository.save(voiture9);
        */


    /*
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

     */
    }
}