package com.dextwelwe.carcomparaison.model.Voiture;
import com.dextwelwe.carcomparaison.DTO.Voiture.VoitureDto;
import com.dextwelwe.carcomparaison.model.Image;
import com.dextwelwe.carcomparaison.model.Rating;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

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
    @Column(unique = true)
    @NonNull
    private String version;
    private String description;
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
    @OneToMany(fetch = FetchType.LAZY)
    private List<Image> images;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Rating> note;
    private String MSRP;

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
                voiture.getImages(),
                voiture.getNote(),
                voiture.getMSRP()
        );
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
}
