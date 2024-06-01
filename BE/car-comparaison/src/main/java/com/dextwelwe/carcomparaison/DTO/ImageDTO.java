package com.dextwelwe.carcomparaison.DTO;
import com.dextwelwe.carcomparaison.model.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ImageDTO {
    private long id;
    private String nomDeFichier;
    private String imageData;
    public Image fromDTO(ImageDTO imageDTO){
        return new Image(
          imageDTO.getId(),
          imageDTO.getNomDeFichier(),
          new ArrayList<>(),
                imageDTO.getImageData().getBytes()
        );
    }
}
