package com.dextwelwe.carcomparaison.model;
import com.dextwelwe.carcomparaison.DTO.RatingDTO;
import com.dextwelwe.carcomparaison.model.Voiture.Voiture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Id
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private Voiture voiture;
    @NonNull
    private double note;
    @Nullable
    private String commentaire;
    public RatingDTO toDto(Rating rating){
        return new RatingDTO(
                rating.getId(),
                rating.getVoiture().toDTOMin(rating.getVoiture()),
                rating.getNote(),
                rating.getCommentaire()
        );
    }
}

