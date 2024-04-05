package com.dextwelwe.carcomparaison.service;
import com.dextwelwe.carcomparaison.model.Voiture.Voiture;
import com.dextwelwe.carcomparaison.repository.VoitureRepository;
import org.springframework.stereotype.Service;
@Service
public class VoitureService {
    private final VoitureRepository voitureRepository;
    public VoitureService(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }
    // Regarde si une voiture avec le meme modele et la meme version existe deja dans la bd
public boolean checkForUniqueNameAndVersion(Voiture voiture){
       Voiture voitureTest = voitureRepository.findByModeleAndVersion(voiture.getModele(), voiture.getVersion());
       return voitureTest != null;
}
public Voiture saveUpdateVoiture(Voiture voiture){
        if (checkForUniqueNameAndVersion(voiture)) {
            voitureRepository.save(voiture);
        }
        return voiture;
}
}
