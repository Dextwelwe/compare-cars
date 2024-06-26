package com.dextwelwe.carcomparaison.model.Voiture;
import com.dextwelwe.carcomparaison.DTO.ImageDTO;
import com.dextwelwe.carcomparaison.DTO.Voiture.VoitureDto;
import com.dextwelwe.carcomparaison.model.Image;
import com.dextwelwe.carcomparaison.model.Rating;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voiture {
    @Id
    private long id;
    @NonNull
    private String marque;
    @NotNull
    private String annee;
    @NonNull
    private String modele;
    @NonNull
    private String version;
    @Column(length = 2048)
    private String description;
    private  String avantages;
    private String desavantages;
    private EnumsVoiture.Transmission transmission;
    private EnumsVoiture.Motricite motricite;
    private EnumsVoiture.TypeCarburant typeCarburant;
    private String typeCarroserie;
    private String moteur;
    private int numPortes;
    private String economieCarburant;
    private String economieCarburantAutoroute;
    private String characteristiques;
    private String couleurs;
    @ManyToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Image> images;
    @OneToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Rating> note;
    private String MSRP;
    private String puissance;
    private String couple;
    private String autonomie;
    private String revues;
    private String vitesseMaximale;

    private String acceleration;

    private String induction;

    public Voiture(long id, String marque, String annee, String version, String modele) {
    this.id = id;
    this.marque = marque;
    this.annee = annee;
    this.version = version;
    this.modele = modele;
    }

    public VoitureDto toDTO(Voiture voiture){
        return new VoitureDto(
                voiture.getId(),
                voiture.getMarque(),
                voiture.getAnnee(),
                voiture.getModele(),
                voiture.getVersion(),
                voiture.getDescription(),
                voiture.getAvantages().split(";"),
                voiture.getDesavantages().split(";"),
                voiture.getTransmission().toString(),
                voiture.getMotricite().toString(),
                voiture.getTypeCarburant().toString(),
                voiture.getTypeCarroserie(),
                voiture.getMoteur(),
                voiture.getNumPortes(),
                voiture.getEconomieCarburant(),
                voiture.getEconomieCarburantAutoroute(),
                voiture.getCharacteristiques(),
                voiture.getCouleurs(),
                voiture.toImageDTO(voiture.getImages()),
                voiture.getNote(),
                voiture.getMSRP(),
                voiture.getPuissance(),
                voiture.getCouple(),
                voiture.getAutonomie(),
                voiture.getRevues(),
                voiture.getVitesseMaximale(),
                voiture.getAcceleration(),
                voiture.getInduction()
        );
    }

    public List<ImageDTO> toImageDTO(List<Image> images){
        List<ImageDTO> imagesDTO  = new ArrayList<>();
        for (Image i : images){
            imagesDTO.add(i.toDTO(i));
        }
        return imagesDTO;
    }
    public VoitureDto toDTOMin(Voiture voiture){
        return new VoitureDto(
                voiture.getId(),
                voiture.getMarque(),
                voiture.getAnnee(),
                voiture.getVersion(),
                voiture.getModele()
        );
    }
    public String[] getRevues() {
        return (revues != null) ? revues.split(";") : new String[0];
    }
}
