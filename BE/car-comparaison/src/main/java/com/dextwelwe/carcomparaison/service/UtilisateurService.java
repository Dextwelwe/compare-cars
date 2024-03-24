package com.dextwelwe.carcomparaison.service;
import com.dextwelwe.carcomparaison.DTO.Users.ConnectionRequest;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTO;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTOGet;
import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
import com.dextwelwe.carcomparaison.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    private final Outils outils = new Outils();
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    public Utilisateur saveUpdateUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurDTO.fromDTO(utilisateurDTO);
        if (outils.anyFieldIsNull(utilisateurDTO)) {
            throw new RuntimeException("Utilisateur n'est pas sauvegarde,car il contient des variables nulles");
        }
        utilisateurRepository.save(utilisateur);
        return utilisateur;
    }
    public UtilisateurDTOGet getUtilisateurDTOGet(ConnectionRequest connectionRequest) throws Exception {
       Utilisateur utilisateur =  utilisateurRepository.findByNomUtilisateur(connectionRequest.getNomUtilisateur());
       if (utilisateur.getMotDePasse().equals(connectionRequest.getMotDePasse())){
           throw new Exception("Mot de passe incorrect");
       }
       return utilisateur.toDTOGet(utilisateur);
    }
}
