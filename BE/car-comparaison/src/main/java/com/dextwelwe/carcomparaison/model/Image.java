package com.dextwelwe.carcomparaison.model;
import com.dextwelwe.carcomparaison.DTO.ImageDTO;
import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
import com.dextwelwe.carcomparaison.model.Voiture.Voiture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image {
    @Id
    private long id;
    @NonNull
    private String nomDeFichier;
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Voiture voiture;
    @OneToOne
    @NonNull
    private Utilisateur proprietaire;
    public ImageDTO toDTO(Image image){
        return new ImageDTO(
                image.getId(),
                image.getNomDeFichier(),
                image.getVoiture().toDTOMin(image.getVoiture()),
                image.getProprietaire().toDTO(image.getProprietaire())
        );
    }
}
