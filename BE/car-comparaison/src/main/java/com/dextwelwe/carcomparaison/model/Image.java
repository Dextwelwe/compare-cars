package com.dextwelwe.carcomparaison.model;
import com.dextwelwe.carcomparaison.DTO.ImageDTO;
import com.dextwelwe.carcomparaison.DTO.Voiture.VoitureDto;
import com.dextwelwe.carcomparaison.model.Voiture.Voiture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Image {
    @Id
    private long id;
    @NonNull
    private String nomDeFichier;
    @NonNull
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "images")
    private List<Voiture> voiture;
    @Lob
    private byte[] imageData;
    public ImageDTO toDTO(Image image){
        return new ImageDTO(
                image.getId(),
                image.getNomDeFichier(),
                image.imageToString(imageData)
        );
    }

    public String imageToString(byte[] img){
        return Base64.getEncoder().encodeToString(img);
    }

    public byte[] imgToByteArray(String path) throws IOException {
        byte[] imageData = null;
        File file = new File(path);
        try {
            FileInputStream fis = new FileInputStream(file);
            imageData = new byte[(int) file.length()];
            fis.read(imageData);
            fis.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return imageData;
    }
}
