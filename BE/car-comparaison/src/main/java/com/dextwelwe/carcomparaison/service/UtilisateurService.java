package com.dextwelwe.carcomparaison.service;
import com.dextwelwe.carcomparaison.model.Compte;
import com.dextwelwe.carcomparaison.repository.UtilisateurRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@NoArgsConstructor
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    public void removeUtilisateur(Compte compte) {utilisateurRepository.delete(compte);}
    public void saveUtilisateur(Compte compte){
        utilisateurRepository.save(compte);
    }
}