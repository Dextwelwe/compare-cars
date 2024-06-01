package com.dextwelwe.carcomparaison.service;
import com.dextwelwe.carcomparaison.model.Image;
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
import java.util.HashMap;
import java.util.List;

/*
CAR NAMES AND IMAGES FORMAT : 'MAKE_MODEL_YEAR_FULLTRIMNAME'
 */
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

    HashMap<String, String> images = new HashMap<String, String>();

    @Override
    public void run(String... args) throws Exception {
        createGestionnaire();
    }
    public void createGestionnaire() throws Exception {

        // SAVE USERS

        Utilisateur utilisateur = new Utilisateur(1, "dex@gmail.com", "Daniel", "mossmoss", new ArrayList<>(), "FUELECONOMYHWY;AUTONOMY;TYPE;TORQUE;POWER;FUELTYPE");
        Utilisateur utilisateur2 = new Utilisateur(2, "Dex123@gmail.com", "Antoine", "mossmoss", new ArrayList<>(), "");

        utilisateurRepository.save(utilisateur);
        utilisateurRepository.save(utilisateur2);

        // GET IMAGES FROM THE FOLDER

        List<String> imagePaths = new ArrayList<>();
        File folder = new File("C:/Users/dextw/OneDrive/Desktop/CarComparaison/BE/car-comparaison/src/main/java/com/dextwelwe/carcomparaison/images");
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String name = file.getName().substring(0, file.getName().lastIndexOf("."));
                    System.out.println(name);
                    images.put(name, file.getAbsolutePath());
                }
            }
        }

        // CREATE IMAGE OBJECT

        Image mustang = new Image();
        mustang.setId(1);
        mustang.setNomDeFichier("mustang");
        mustang.setImageData(mustang.imgToByteArray(images.get("mustang")));

        Image mustang2 = new Image();
        mustang2.setId(4);
        mustang2.setNomDeFichier("mustang");
        mustang2.setImageData(mustang.imgToByteArray(images.get("mustang2022Ecoboost")));

        Image corolla = new Image();
        corolla.setId(5);
        corolla.setNomDeFichier("corolla");
        corolla.setImageData(corolla.imgToByteArray(images.get("zCorolla")));

        Image mazda3_2010_gt_man = new Image();
        mazda3_2010_gt_man.setId(6);
        mazda3_2010_gt_man.setImageData(mazda3_2010_gt_man.imgToByteArray(images.get("mazda3_2010")));

        Image mazda3_2010_gt_aut = new Image();
        mazda3_2010_gt_aut.setId(7);
        mazda3_2010_gt_aut.setImageData(mazda3_2010_gt_aut.imgToByteArray(images.get("mazda3_2010")));

        Image mazda3_2010_gx_aut = new Image();
        mazda3_2010_gx_aut.setId(13);
        mazda3_2010_gx_aut.setImageData(mazda3_2010_gx_aut.imgToByteArray(images.get("mazda3_2010")));

        Image honda_civic_2012 = new Image();
        honda_civic_2012.setId(14);
        honda_civic_2012.setImageData(honda_civic_2012.imgToByteArray(images.get("civic_2012")));

        Image honda_civic_2013 = new Image();
        honda_civic_2013.setId(15);
        honda_civic_2013.setImageData(honda_civic_2013.imgToByteArray(images.get("civic_2013")));

        // CREATE CAR OBJECTS

        String descMustang = "The iconic pony car makes its comeback in 2022, boasting few significant alterations aside from some fresh package options. The standard Mustang retains its turbocharged 2.3-liter four-cylinder engine, while the GT and Mach 1 variants are equipped with a robust 5.0-liter V8. However, the Mustang Shelby GT500 takes performance to unparalleled levels, featuring a supercharged 5.2-liter V8 engine generating an impressive 760 horsepower and 625 pound-feet of torque.";
        String descCorolla = "Toyota has introduced several updates for the 2022 Corolla and Corolla Hatchback. These revisions encompass fresh body paint options, the replacement of the Special Edition with the Nightshade Edition, and the addition of a new JBL audio system featuring eight speakers in the Corolla Hatchback XSE. Most other aspects remain unchanged, including the 1.8-liter and 2.0-liter engines, which deliver 139 and 169 horsepower, respectively. The Corolla Hybrid stands as a more eco-friendly option for those seeking fuel efficiency.";

        Voiture Corolla = new Voiture(1,
                "Toyota",
                "2022",
                "Corolla",
                "LE",
                descCorolla,
                "Solid reliability reputation;Attractive fuel consumption;Surprisingly fun to drive",
                "Small switches on the instrument panel;Reduced rear visibility (Hatchback);Limited space at the rear",
                EnumsVoiture.Transmission.Automatic,
                EnumsVoiture.Motricite.FWD,
                EnumsVoiture.TypeCarburant.GAS,
                "Sedan",
                "1,8 l I-4" ,
                4 ,
                "8.0 L/100km",
                "6.0 L/100km",
                "Backup camera,Lane departure warning",
                "Silver, Black, White",
                new ArrayList<>(),
                new ArrayList<>(),
                "CA$19,450",
                "139 hp @ 6,100 rpm (104 kW)",
                "126 lb·ft @ 3,900 rpm (171 N·m)",
                "704 km",
                "https://www.youtube.com/embed/28EOZjnvIJM?si=sSo23C4orsNzLXPA;https://www.youtube.com/embed/2KhhqJtEhQo?si=uw_vZEjy1Q17oM4D;https://www.youtube.com/embed/1SV4pAz2b-E?si=myNH-8lUljl78oid",
                "180 kmh",
                "9.8 s",
                "Atmospheric");


        Voiture Mustang = new Voiture(4,
                "Ford",
                "2022",
                "Mustang",
                "EcoBoost FastBack",
                descMustang,
                "Very attractive Mach 1 model;Colossal performance (GT500); blast to drive;Good reliability",
                "Price is going up; Disappointing 4-cylinder engine; Aging model; Layout details (interior)",
                EnumsVoiture.Transmission.Manual,
                EnumsVoiture.Motricite.RWD,
                EnumsVoiture.TypeCarburant.GAS,
                "Coupe",
                "2,3 l I-4",
                2,
                "11.5 L/100km",
                "8.2 L/100km",
                "Track package available",
                "Yellow, Red, Black",
                null, new ArrayList<>(),
                "CA$32,295",
                "310 hp @ 5,500 rpm (231 kW)",
                "350 lb·ft @ 3,000 rpm (475 N·m)",
                "580 km",
                "https://www.youtube.com/embed/n9CdWqt7o1k?si=nWRqYneTn-5Bzstt",
                "233 km/h (145 mph)",
                "6.2 s (estimated)",
                "Turbocharged");

        Voiture MustangGT = new Voiture(10,
                "Ford",
                "2023",
                "Mustang",
                "GT",
                descMustang,
                "Very attractive Mach 1 model;Colossal performance (GT500);A blast to drive;Good reliability",
                "Price is going up; Disappointing 4-cylinder engine; Aging model; Layout details (interior)",
                EnumsVoiture.Transmission.Automatic,
                EnumsVoiture.Motricite.RWD,
                EnumsVoiture.TypeCarburant.GAS,
                "Coupe",
                "5.0L V8",
                2,
                "15.8 L/100km",
                "10.4 L/100km",
                "Track package available",
                "Yellow,Red,Black",
                null, new ArrayList<>(),
                "CA$58,495",
                "450 hp @ 7,000 rpm (336 kW)",
                "410 lb·ft @ 4,600 rpm (556 N·m)",
                "447 km",
                "https://www.youtube.com/embed/eFWUQc-wDzI?si=mh7PKeEYFH_LaH5C",
                "249 km/h (155 mph) ",
                "5.2 s",
                "Atmospheric");

        Voiture Mazda3_2010_GX_SEDAN_AUT = new Voiture();
        Mazda3_2010_GX_SEDAN_AUT.setAnnee("2010");
        Mazda3_2010_GX_SEDAN_AUT.setId(11);
        Mazda3_2010_GX_SEDAN_AUT.setMarque("Mazda");
        Mazda3_2010_GX_SEDAN_AUT.setModele("Mazda3");
        Mazda3_2010_GX_SEDAN_AUT.setVersion("GX (sedan,automatic)");
        Mazda3_2010_GX_SEDAN_AUT.setDescription("Inheriting an unparalleled legacy of success, the Mazda 3 continues to assert its dominance in the market. Its more athletic appearance has propelled it past its primary competitor, the Honda Civic. For 2010, the Mazda 3 debuts a fresh design and introduces a new 2.0-liter engine. Buyers can choose from three sedan variations and the 3Sport. Moreover, the MazdaSpeed makes a comeback, now a bit more refined but still retaining every ounce of its sporty character!");
        Mazda3_2010_GX_SEDAN_AUT.setAvantages("It's a fun-to-drive, maneuverable little car. It's quick off the line and easy to control.;Mazda 3 is good on gas, especially with the Skyactiv 2.0L engine;Easy to maintain and repair;  ");
        Mazda3_2010_GX_SEDAN_AUT.setDesavantages("The ride is sporty-firm and the interior is not very quiet.;Rear tires will become cupped and noisy if not rotated regularly;The TCM may fail in non-Skyactiv models, wheel bearings, control arms, struts and shock absorbers are common to go bad.");
        Mazda3_2010_GX_SEDAN_AUT.setTransmission(EnumsVoiture.Transmission.Automatic);
        Mazda3_2010_GX_SEDAN_AUT.setMotricite(EnumsVoiture.Motricite.FWD);
        Mazda3_2010_GX_SEDAN_AUT.setTypeCarburant(EnumsVoiture.TypeCarburant.GAS);
        Mazda3_2010_GX_SEDAN_AUT.setTypeCarroserie("SEDAN");
        Mazda3_2010_GX_SEDAN_AUT.setMoteur("2,0 l I-4");
        Mazda3_2010_GX_SEDAN_AUT.setNumPortes(4);
        Mazda3_2010_GX_SEDAN_AUT.setEconomieCarburant("8.1 L/100km");
        Mazda3_2010_GX_SEDAN_AUT.setEconomieCarburantAutoroute("5.9 L/100km");
        Mazda3_2010_GX_SEDAN_AUT.setCharacteristiques("The 2010 Mazda 3 stands out with its sleek design, versatile options including a new 2.0-liter engine, and the return of the sporty MazdaSpeed variant, offering a dynamic driving experience with enhanced features and modern amenities.");
        Mazda3_2010_GX_SEDAN_AUT.setCouleurs("Crystal White Pearl, Liquid Silver Metallic, Gunmetal Blue Mica, Graphite Mica, Celestial Blue Mica, Copper Red Mica, Black Mica");
        Mazda3_2010_GX_SEDAN_AUT.setMSRP("CA$15,995");
        Mazda3_2010_GX_SEDAN_AUT.setPuissance("148 hp @ 6,500 rpm (110 kW)");
        Mazda3_2010_GX_SEDAN_AUT.setCouple("135 lb·ft @ 4,500 rpm (183 N·m)");
        Mazda3_2010_GX_SEDAN_AUT.setAutonomie("774 km");
        Mazda3_2010_GX_SEDAN_AUT.setVitesseMaximale("185 to 201kmp (estimate)");
        Mazda3_2010_GX_SEDAN_AUT.setAcceleration("8.8 sec");
        Mazda3_2010_GX_SEDAN_AUT.setInduction("Atmospheric");
        Mazda3_2010_GX_SEDAN_AUT.setImages(null);
        Mazda3_2010_GX_SEDAN_AUT.setNote(null);


        Voiture Mazda3_2010_GT_SEDAN_AUT = new Voiture();
        Mazda3_2010_GT_SEDAN_AUT.setId(12);
        Mazda3_2010_GT_SEDAN_AUT.setAnnee("2010");
        Mazda3_2010_GT_SEDAN_AUT.setMarque("Mazda");
        Mazda3_2010_GT_SEDAN_AUT.setModele("Mazda3");
        Mazda3_2010_GT_SEDAN_AUT.setVersion("GT (sedan,manual)");
        Mazda3_2010_GT_SEDAN_AUT.setDescription("Inheriting an unparalleled legacy of success, the Mazda 3 continues to assert its dominance in the market. Its more athletic appearance has propelled it past its primary competitor, the Honda Civic. For 2010, the Mazda 3 debuts a fresh design and introduces a new 2.5-liter engine. Buyers can choose from three sedan variations and the 3Sport. Moreover, the MazdaSpeed makes a comeback, now a bit more refined but still retaining every ounce of its sporty character!");
        Mazda3_2010_GT_SEDAN_AUT.setAvantages("It's a fun-to-drive, maneuverable little car. It's quick off the line and easy to control.;Mazda 3 is good on gas, especially with the Skyactiv 2.5L engine;Easy to maintain and repair;  ");
        Mazda3_2010_GT_SEDAN_AUT.setDesavantages("The ride is sporty-firm and the interior is not very quiet.;Rear tires will become cupped and noisy if not rotated regularly;The TCM may fail in non-Skyactiv models, wheel bearings, control arms, struts and shock absorbers are common to go bad.");
        Mazda3_2010_GT_SEDAN_AUT.setTransmission(EnumsVoiture.Transmission.Automatic);
        Mazda3_2010_GT_SEDAN_AUT.setMotricite(EnumsVoiture.Motricite.FWD);
        Mazda3_2010_GT_SEDAN_AUT.setTypeCarburant(EnumsVoiture.TypeCarburant.GAS);
        Mazda3_2010_GT_SEDAN_AUT.setTypeCarroserie("SEDAN");
        Mazda3_2010_GT_SEDAN_AUT.setMoteur("2.5 l I-4");
        Mazda3_2010_GT_SEDAN_AUT.setNumPortes(4);
        Mazda3_2010_GT_SEDAN_AUT.setEconomieCarburant("9.2 L/100km");
        Mazda3_2010_GT_SEDAN_AUT.setEconomieCarburantAutoroute("6.5 L/100km");
        Mazda3_2010_GT_SEDAN_AUT.setCharacteristiques("The 2010 Mazda 3 stands out with its sleek design, versatile options including a new 2.5-liter engine, and the return of the sporty MazdaSpeed variant, offering a dynamic driving experience with enhanced features and modern amenities.");
        Mazda3_2010_GT_SEDAN_AUT.setCouleurs("Crystal White Pearl, Liquid Silver Metallic, Gunmetal Blue Mica, Graphite Mica, Celestial Blue Mica, Copper Red Mica, Black Mica");
        Mazda3_2010_GT_SEDAN_AUT.setMSRP("CA$20,445");
        Mazda3_2010_GT_SEDAN_AUT.setPuissance("168 hp @ 6,000 rpm (125 kW)");
        Mazda3_2010_GT_SEDAN_AUT.setCouple("167 lb·ft @ 4,000 rpm (226 N·m)");
        Mazda3_2010_GT_SEDAN_AUT.setAutonomie("671 km");
        Mazda3_2010_GT_SEDAN_AUT.setVitesseMaximale("200 to 210kmp (estimate)");
        Mazda3_2010_GT_SEDAN_AUT.setAcceleration("7.9 sec");
        Mazda3_2010_GT_SEDAN_AUT.setInduction("Atmospheric");
        Mazda3_2010_GT_SEDAN_AUT.setImages(null);
        Mazda3_2010_GT_SEDAN_AUT.setNote(null);

        Voiture Mazda3_2010_GT_SEDAN_MAN = new Voiture();
        Mazda3_2010_GT_SEDAN_MAN.setAnnee("2010");
        Mazda3_2010_GT_SEDAN_MAN.setId(13);
        Mazda3_2010_GT_SEDAN_MAN.setMarque("Mazda");
        Mazda3_2010_GT_SEDAN_MAN.setModele("Mazda3");
        Mazda3_2010_GT_SEDAN_MAN.setVersion("GT (sedan,automatic)");
        Mazda3_2010_GT_SEDAN_MAN.setDescription("Inheriting an unparalleled legacy of success, the Mazda 3 continues to assert its dominance in the market. Its more athletic appearance has propelled it past its primary competitor, the Honda Civic. For 2010, the Mazda 3 debuts a fresh design and introduces a new 2.5-liter engine. Buyers can choose from three sedan variations and the 3Sport. Moreover, the MazdaSpeed makes a comeback, now a bit more refined but still retaining every ounce of its sporty character!");
        Mazda3_2010_GT_SEDAN_MAN.setAvantages("It's a fun-to-drive, maneuverable little car. It's quick off the line and easy to control.;Mazda 3 is good on gas, especially with the Skyactiv 2.5L engine;Easy to maintain and repair;  ");
        Mazda3_2010_GT_SEDAN_MAN.setDesavantages("The ride is sporty-firm and the interior is not very quiet.;Rear tires will become cupped and noisy if not rotated regularly;The TCM may fail in non-Skyactiv models, wheel bearings, control arms, struts and shock absorbers are common to go bad.");
        Mazda3_2010_GT_SEDAN_MAN.setTransmission(EnumsVoiture.Transmission.Automatic);
        Mazda3_2010_GT_SEDAN_MAN.setMotricite(EnumsVoiture.Motricite.FWD);
        Mazda3_2010_GT_SEDAN_MAN.setTypeCarburant(EnumsVoiture.TypeCarburant.GAS);
        Mazda3_2010_GT_SEDAN_MAN.setTypeCarroserie("SEDAN");
        Mazda3_2010_GT_SEDAN_MAN.setMoteur("2.5 l I-4");
        Mazda3_2010_GT_SEDAN_MAN.setNumPortes(4);
        Mazda3_2010_GT_SEDAN_MAN.setEconomieCarburant("9.2 L/100km");
        Mazda3_2010_GT_SEDAN_MAN.setEconomieCarburantAutoroute("6.5 L/100km");
        Mazda3_2010_GT_SEDAN_MAN.setCharacteristiques("The 2010 Mazda 3 stands out with its sleek design, versatile options including a new 2.5-liter engine, and the return of the sporty MazdaSpeed variant, offering a dynamic driving experience with enhanced features and modern amenities.");
        Mazda3_2010_GT_SEDAN_MAN.setCouleurs("Crystal White Pearl, Liquid Silver Metallic, Gunmetal Blue Mica, Graphite Mica, Celestial Blue Mica, Copper Red Mica, Black Mica");
        Mazda3_2010_GT_SEDAN_MAN.setMSRP("CA$20,445");
        Mazda3_2010_GT_SEDAN_MAN.setPuissance("168 hp @ 6,000 rpm (125 kW)");
        Mazda3_2010_GT_SEDAN_MAN.setCouple("167 lb·ft @ 4,000 rpm (226 N·m)");
        Mazda3_2010_GT_SEDAN_MAN.setAutonomie("671 km");
        Mazda3_2010_GT_SEDAN_MAN.setVitesseMaximale("200 to 210kmp (estimate)");
        Mazda3_2010_GT_SEDAN_MAN.setAcceleration("7.9 sec");
        Mazda3_2010_GT_SEDAN_MAN.setInduction("Atmospheric");
        Mazda3_2010_GT_SEDAN_MAN.setImages(null);
        Mazda3_2010_GT_SEDAN_MAN.setNote(null);

        Voiture HondaCivic_2012_Touring_AUT = new Voiture();
        HondaCivic_2012_Touring_AUT.setAnnee("2012");
        HondaCivic_2012_Touring_AUT.setId(14);
        HondaCivic_2012_Touring_AUT.setMarque("Honda");
        HondaCivic_2012_Touring_AUT.setModele("Civic");
        HondaCivic_2012_Touring_AUT.setVersion("Touring (automatic)");
        HondaCivic_2012_Touring_AUT.setDescription("The 2012 Honda Civic Touring offers a blend of style, comfort, and performance. With its sleek design and advanced features, it stands out in its class. Equipped with a powerful yet efficient engine, the Civic Touring delivers a smooth and responsive driving experience. Its luxurious interior and cutting-edge technology ensure a comfortable and convenient ride for both driver and passengers. Whether navigating city streets or cruising on the highway, the Civic Touring provides a refined and enjoyable driving experience.");
        HondaCivic_2012_Touring_AUT.setAvantages("Sleek and stylish design; Comfortable and spacious interior; Smooth and responsive performance; Advanced technology features.");
        HondaCivic_2012_Touring_AUT.setDesavantages("Some may find the ride quality to be firmer than expected; Infotainment system interface could be more user-friendly; Limited cargo space in the trunk.");
        HondaCivic_2012_Touring_AUT.setTransmission(EnumsVoiture.Transmission.Automatic);
        HondaCivic_2012_Touring_AUT.setMotricite(EnumsVoiture.Motricite.FWD);
        HondaCivic_2012_Touring_AUT.setTypeCarburant(EnumsVoiture.TypeCarburant.GAS);
        HondaCivic_2012_Touring_AUT.setTypeCarroserie("SEDAN");
        HondaCivic_2012_Touring_AUT.setMoteur("1.8L I4");
        HondaCivic_2012_Touring_AUT.setNumPortes(4);
        HondaCivic_2012_Touring_AUT.setEconomieCarburant("7.2 L/100km");
        HondaCivic_2012_Touring_AUT.setEconomieCarburantAutoroute("5.5 L/100km");
        HondaCivic_2012_Touring_AUT.setCharacteristiques("The 2012 Honda Civic Touring combines style, comfort, and performance to offer a refined driving experience. With its sleek design, advanced features, and smooth performance, it stands out in its class.");
        HondaCivic_2012_Touring_AUT.setCouleurs("Alabaster Silver Metallic, Crystal Black Pearl, Polished Metal Metallic, Cool Mist Metallic, Dyno Blue Pearl, Taffeta White, Crimson Pearl");
        HondaCivic_2012_Touring_AUT.setMSRP("CA$21,695");
        HondaCivic_2012_Touring_AUT.setPuissance("140 hp @ 6,500 rpm (104 kW)");
        HondaCivic_2012_Touring_AUT.setCouple("128 lb-ft @ 4,300 rpm (174 N·m)");
        HondaCivic_2012_Touring_AUT.setAutonomie("Approximately 660 km");
        HondaCivic_2012_Touring_AUT.setVitesseMaximale("180 to 190 km/h (estimated)");
        HondaCivic_2012_Touring_AUT.setAcceleration("Approximately 9.2 seconds (0-100 km/h)");
        HondaCivic_2012_Touring_AUT.setInduction("Atmospheric");
        HondaCivic_2012_Touring_AUT.setImages(null);
        HondaCivic_2012_Touring_AUT.setNote(null);

        Voiture HondaCivic_2013_Touring_AUT = new Voiture();
        HondaCivic_2013_Touring_AUT.setAnnee("2013");
        HondaCivic_2013_Touring_AUT.setId(15);
        HondaCivic_2013_Touring_AUT.setMarque("Honda");
        HondaCivic_2013_Touring_AUT.setModele("Civic");
        HondaCivic_2013_Touring_AUT.setVersion("Touring (automatic)");
        HondaCivic_2013_Touring_AUT.setDescription("The 2013 Honda Civic Touring offers a blend of style, comfort, and performance. With its sleek design and advanced features, it stands out in its class. Equipped with a powerful yet efficient engine, the Civic Touring delivers a smooth and responsive driving experience. Its luxurious interior and cutting-edge technology ensure a comfortable and convenient ride for both driver and passengers. Whether navigating city streets or cruising on the highway, the Civic Touring provides a refined and enjoyable driving experience.");
        HondaCivic_2013_Touring_AUT.setAvantages("Sleek and stylish design; Comfortable and spacious interior; Smooth and responsive performance; Advanced technology features.");
        HondaCivic_2013_Touring_AUT.setDesavantages("Some may find the ride quality to be firmer than expected; Infotainment system interface could be more user-friendly; Limited cargo space in the trunk.");
        HondaCivic_2013_Touring_AUT.setTransmission(EnumsVoiture.Transmission.Automatic);
        HondaCivic_2013_Touring_AUT.setMotricite(EnumsVoiture.Motricite.FWD);
        HondaCivic_2013_Touring_AUT.setTypeCarburant(EnumsVoiture.TypeCarburant.GAS);
        HondaCivic_2013_Touring_AUT.setTypeCarroserie("SEDAN");
        HondaCivic_2013_Touring_AUT.setMoteur("1.8L I4");
        HondaCivic_2013_Touring_AUT.setNumPortes(4);
        HondaCivic_2013_Touring_AUT.setEconomieCarburant("7.2 L/100km");
        HondaCivic_2013_Touring_AUT.setEconomieCarburantAutoroute("5.5 L/100km");
        HondaCivic_2013_Touring_AUT.setCharacteristiques("The 2013 Honda Civic Touring combines style, comfort, and performance to offer a refined driving experience. With its sleek design, advanced features, and smooth performance, it stands out in its class.");
        HondaCivic_2013_Touring_AUT.setCouleurs("Alabaster Silver Metallic, Crystal Black Pearl, Polished Metal Metallic, Cool Mist Metallic, Dyno Blue Pearl, Taffeta White, Crimson Pearl");
        HondaCivic_2013_Touring_AUT.setMSRP("CA$21,995");
        HondaCivic_2013_Touring_AUT.setPuissance("140 hp @ 6,500 rpm (104 kW)");
        HondaCivic_2013_Touring_AUT.setCouple("128 lb-ft @ 4,300 rpm (174 N·m)");
        HondaCivic_2013_Touring_AUT.setAutonomie("Approximately 660 km");
        HondaCivic_2013_Touring_AUT.setVitesseMaximale("180 to 190 km/h (estimated)");
        HondaCivic_2013_Touring_AUT.setAcceleration("Approximately 9.2 seconds (0-100 km/h)");
        HondaCivic_2013_Touring_AUT.setInduction("Atmospheric");
        HondaCivic_2013_Touring_AUT.setImages(null);
        HondaCivic_2013_Touring_AUT.setNote(null);

        // LIST OF IMAGES

        List<Image> mustangList = List.of(mustang);
        List<Image> mustangList2 = List.of(mustang2);
        List<Image> corollaList = List.of(corolla);
        List<Image> Mazda3_2010_GX_SEDAN_AUT_IMG = List.of(mazda3_2010_gx_aut);
        List<Image> Mazda3_2010_GT_SEDAN_AUT_IMG = List.of(mazda3_2010_gt_aut);
        List<Image> Mazda3_2010_GT_SEDAN_MAN_IMG = List.of(mazda3_2010_gt_man);
        List<Image> HondaCivic_2012_Touring_IMG = List.of(honda_civic_2012);
        List<Image> HondaCivic_2013_Touring_IMG = List.of(honda_civic_2013);

        Mustang.setImages(mustangList);
        MustangGT.setImages(mustangList2);
        Corolla.setImages(corollaList);
        Mazda3_2010_GT_SEDAN_AUT.setImages(Mazda3_2010_GT_SEDAN_AUT_IMG);
        Mazda3_2010_GX_SEDAN_AUT.setImages(Mazda3_2010_GX_SEDAN_AUT_IMG);
        Mazda3_2010_GT_SEDAN_MAN.setImages(Mazda3_2010_GT_SEDAN_MAN_IMG);
        HondaCivic_2012_Touring_AUT.setImages(HondaCivic_2012_Touring_IMG);
        HondaCivic_2013_Touring_AUT.setImages(HondaCivic_2013_Touring_IMG);

        // SAVE CARS AND IMAGES

        imageRepository.save(mustang);
        imageRepository.save(mustang2);
        imageRepository.save(corolla);
        imageRepository.save(mazda3_2010_gt_aut);
        imageRepository.save(mazda3_2010_gt_man);
        imageRepository.save(mazda3_2010_gx_aut);
        imageRepository.save(honda_civic_2012);
        imageRepository.save(honda_civic_2013);


        voitureRepository.save(Mustang);
        voitureRepository.save(MustangGT);
        voitureRepository.save(Corolla);
        voitureRepository.save(Mazda3_2010_GT_SEDAN_AUT);
        voitureRepository.save(Mazda3_2010_GT_SEDAN_MAN);
        voitureRepository.save(Mazda3_2010_GX_SEDAN_AUT);
        voitureRepository.save(HondaCivic_2012_Touring_AUT);
        voitureRepository.save(HondaCivic_2013_Touring_AUT);



        imageRepository.save(mustang);
        imageRepository.save(mustang2);
        imageRepository.save(corolla);
        imageRepository.save(mazda3_2010_gt_aut);
        imageRepository.save(mazda3_2010_gt_man);
        imageRepository.save(mazda3_2010_gx_aut);
        imageRepository.save(honda_civic_2012);
        imageRepository.save(honda_civic_2013);

    }
}