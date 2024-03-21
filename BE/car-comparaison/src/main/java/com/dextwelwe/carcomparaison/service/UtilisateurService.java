package com.dextwelwe.carcomparaison.service;
import com.dextwelwe.carcomparaison.DTO.Users.ConnectionRequest;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTO;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTOGet;
import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
import com.dextwelwe.carcomparaison.repository.UtilisateurRepository;
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
    public Utilisateur saveUpdateUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurDTO.fromDTO(utilisateurDTO);
        if (!outils.anyFieldIsNull(utilisateurDTO)) {
            utilisateurRepository.save(utilisateur);
            return utilisateur;
        } else {
            throw new RuntimeException("Utilisateur n'est pas sauvegarde,car il contient des variables nulles");
        }
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
