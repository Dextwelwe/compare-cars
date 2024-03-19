package com.dextwelwe.carcomparaison.DTO;
import com.dextwelwe.carcomparaison.DTO.Voiture.VoitureDto;
import com.dextwelwe.carcomparaison.model.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class RatingDTO {
    private long id;
    private VoitureDto voitureDto;
    private double note;
    private String commentaire;

    public Rating fromDTO(RatingDTO ratingDTO){
        return new Rating(
                ratingDTO.getId(),
                ratingDTO.getVoitureDto().fromDTOMin(ratingDTO.getVoitureDto()),
                ratingDTO.getNote(),
                ratingDTO.getCommentaire()
        );
    }
}
