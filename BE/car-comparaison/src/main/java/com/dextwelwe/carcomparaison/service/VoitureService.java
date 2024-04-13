package com.dextwelwe.carcomparaison.service;
import com.dextwelwe.carcomparaison.DTO.Voiture.VoitureDto;
import com.dextwelwe.carcomparaison.model.Voiture.Voiture;
import com.dextwelwe.carcomparaison.repository.VoitureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoitureService {
    private final VoitureRepository voitureRepository;
    public VoitureService(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }
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
public List<String> getListMakes(){
   return voitureRepository.getListeMarques();
}
public List<String> getListModels(String marque){
   return voitureRepository.getListOfModels(marque);
}
public List<String> getListModelYears(String marque, String modele){
      return voitureRepository.getListOfModelYear(marque,modele);
}
public List<String> getListTrims(String marque, String modele, String annee){
        return voitureRepository.findAllTrims(marque, modele, annee);
}
public VoitureDto getCar(Long id){
        Optional<Voiture> voiture = voitureRepository.findById(id);
        return voiture.get().toDTO(voiture.get());
}

public long getCarId(String marque, String modele, String annee, String version){
        return voitureRepository.findId(marque, modele, annee, version);
}
}
