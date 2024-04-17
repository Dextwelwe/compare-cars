package com.dextwelwe.carcomparaison.DTO.Voiture;
import com.dextwelwe.carcomparaison.model.Image;
import com.dextwelwe.carcomparaison.model.Rating;
import com.dextwelwe.carcomparaison.model.Voiture.Voiture;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
@Data
@AllArgsConstructor
public class VoitureDto {
    private long id;
    private String marque;
    private String annee;
    private String modele;
    private String version;
    private String description;
    private String avantages;
    private String desavantages;
    private String transmission;
    private String motricite;
    private String typeCarburant;
    private String typeCarroserie;
    private String moteur;
    private int numPortes;
    private String economieCarburant;
    private String economieCarburantAutoroute;
    private String characteristiques;
    private String couleurs;
    private List<Image> images;
    private List<Rating> note;
    private String MSRP;
    private String puissance;
    private String couple;
    private String autonomie;

    public VoitureDto(long id, String marque, String annee, String version, String modele) {
        this.id = id;
        this.marque = marque;
        this.annee = annee;
        this.version = version;
        this.modele = modele;
    }
    public Voiture fromDTOMin(VoitureDto voitureDto){
        return new Voiture(
                voitureDto.getId(),
                voitureDto.getMarque(),
                voitureDto.getAnnee(),
                voitureDto.getVersion(),
                voitureDto.getModele()
        );
    }
}
