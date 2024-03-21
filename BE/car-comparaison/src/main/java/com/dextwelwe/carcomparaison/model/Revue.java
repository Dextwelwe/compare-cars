package com.dextwelwe.carcomparaison.model;
import com.dextwelwe.carcomparaison.DTO.ImageDTO;
import com.dextwelwe.carcomparaison.DTO.RevueDTO;
import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
import com.dextwelwe.carcomparaison.model.Voiture.Voiture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Revue {
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name="NOM_UTILISATEUR")
    @ToString.Exclude
    private Utilisateur utilisateur;
    @OneToOne
    @ToString.Exclude
    private Voiture voiture;
    private String titre;
    @OneToMany
    @ToString.Exclude
    private List<Image> images;
    private String description;

    public RevueDTO toDTO(Revue revue){
        List<ImageDTO> imgtmp = new ArrayList<>();
        for (Image e : images){
            imgtmp.add(e.toDTO(e));
        }
        return new RevueDTO(
                revue.getId(),
                revue.getUtilisateur().toDTO(revue.getUtilisateur()),
                revue.getVoiture().toDTOMin(revue.getVoiture()),
                revue.getTitre(),
                imgtmp,
                revue.getDescription()
        );
    }
}
