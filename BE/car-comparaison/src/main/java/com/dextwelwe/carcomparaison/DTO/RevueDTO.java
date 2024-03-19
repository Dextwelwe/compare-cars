package com.dextwelwe.carcomparaison.DTO;

import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTO;
import com.dextwelwe.carcomparaison.DTO.Voiture.VoitureDto;
import com.dextwelwe.carcomparaison.model.Image;
import com.dextwelwe.carcomparaison.model.Revue;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
public class RevueDTO {
    private long id;
    private UtilisateurDTO utilisateurDTO;
    private VoitureDto voitureDto;
    private String titre;
    private List<ImageDTO> imagesDTO;
    private String description;
    public Revue fromDTO(RevueDTO revueDTO){
        List<Image> imageDTOS = new ArrayList<>();
        for (ImageDTO e : imagesDTO){
            imageDTOS.add(e.fromDTO(e));
        }
        return new Revue(
                revueDTO.getId(),
                revueDTO.getUtilisateurDTO().fromDTO(revueDTO.getUtilisateurDTO()),
                revueDTO.getVoitureDto().fromDTOMin(revueDTO.getVoitureDto()),
                revueDTO.getTitre(),
                imageDTOS,
                revueDTO.getDescription()
        );
    }
}
