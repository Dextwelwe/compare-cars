package com.dextwelwe.carcomparaison.service;
import com.dextwelwe.carcomparaison.DTO.Users.ConnectionRequest;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTOGet;
import com.dextwelwe.carcomparaison.model.Users.Compte;
import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
import com.dextwelwe.carcomparaison.repository.UtilisateurRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@NoArgsConstructor
public class UtilisateurService {
    private UtilisateurRepository utilisateurRepository;
    private final Outils outils = new Outils();
    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public void removeUtilisateur(Compte compte) {utilisateurRepository.delete(compte);}
    public Compte saveUtilisateur(Compte compte) {
        if (!outils.anyFieldIsNull(compte)) {
            utilisateurRepository.save(compte);
            return compte;
        }
        return null;
    }

    public UtilisateurDTOGet getUtilisateurDTOGet(ConnectionRequest connectionRequest) throws Exception {
       Utilisateur utilisateur =  utilisateurRepository.findByNomUtilisateur(connectionRequest.getNomUtilisateur());
       if (utilisateur.getMotDePasse().equals(connectionRequest.getMotDePasse())){
           return utilisateur.toDTOGet(utilisateur);
       } else {
           throw new Exception("Mot de passe incorrect");
       }
    }
}
