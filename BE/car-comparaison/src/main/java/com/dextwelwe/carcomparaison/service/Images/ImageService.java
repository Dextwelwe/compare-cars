package com.dextwelwe.carcomparaison.service.Images;
import com.dextwelwe.carcomparaison.model.Image;
import com.dextwelwe.carcomparaison.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
@Service
public class ImageService {
   private final ImageRepository imageRepository;
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    public void uploadImage(MultipartFile imageFile) throws IOException {
        var imageToSave = Image.builder()
                .nomDeFichier(imageFile.getOriginalFilename())
                .imageData(ImageUtils.compressImage(imageFile.getBytes()))
                .build();
        imageRepository.save(imageToSave);
    }
    public byte[] downloadImage(String imageName) {
        Optional<Image> dbImage = imageRepository.findByNomDeFichier(imageName);
        return dbImage.map(image -> {
            try {
                return ImageUtils.decompressImage(image.getImageData());
            } catch (DataFormatException | IOException exception) {
                throw new ContextedRuntimeException("Error downloading an image", exception)
                        .addContextValue("Image ID",  image.getId())
                        .addContextValue("Image name", imageName);
            }
        }).orElse(null);
    }
}
