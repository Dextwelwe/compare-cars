package com.dextwelwe.carcomparaison.model.Voiture;
import com.dextwelwe.carcomparaison.model.Image;
import com.dextwelwe.carcomparaison.model.Rating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voiture {
    @Id
    private long id;
    private String marque;
    private String annee;
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
}
