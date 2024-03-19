package com.dextwelwe.carcomparaison.DTO;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTO;
import com.dextwelwe.carcomparaison.DTO.Voiture.VoitureDto;
import com.dextwelwe.carcomparaison.model.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ImageDTO {
    private long id;
    private String nomDeFichier;
    private VoitureDto voitureDto;
    private UtilisateurDTO utilisateurDTO;
    public Image fromDTO(ImageDTO imageDTO){
        return new Image(
          imageDTO.getId(),
          imageDTO.getNomDeFichier(),
          imageDTO.voitureDto.fromDTOMin(imageDTO.getVoitureDto()),
          imageDTO.getUtilisateurDTO().fromDTO(imageDTO.getUtilisateurDTO())
        );
    }
}
