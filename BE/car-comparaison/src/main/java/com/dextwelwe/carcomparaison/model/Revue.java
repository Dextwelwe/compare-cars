package com.dextwelwe.carcomparaison.model;
import com.dextwelwe.carcomparaison.DTO.ImageDTO;
import com.dextwelwe.carcomparaison.DTO.RevueDTO;
import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
import com.dextwelwe.carcomparaison.model.Voiture.Voiture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private Utilisateur utilisateur;
    @OneToOne()
    private Voiture voiture;
    private String titre;
    @OneToMany(fetch = FetchType.LAZY)
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
