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
    public Utilisateur saveUtilisateur(UtilisateurDTO utilisateurDTO) throws Exception {
        Utilisateur utilisateur = utilisateurDTO.fromDTO(utilisateurDTO);
        if (isUnique(utilisateurDTO)){
            utilisateurRepository.save(utilisateur);
        }
        return utilisateur;
    }
    public UtilisateurDTOGet getUtilisateurDTOGet(ConnectionRequest connectionRequest) throws Exception {
       Utilisateur utilisateur =  utilisateurRepository.findByNomUtilisateur(connectionRequest.getNomUtilisateur());
       if (utilisateur.getMotDePasse().equals(connectionRequest.getMotDePasse())){
           return utilisateur.toDTOGet(utilisateur);
       }
        throw new Exception("Username or password are incorrect.");
    }

    public boolean isUnique(UtilisateurDTO utilisateurDTO) throws Exception {
        Utilisateur utilisateur = utilisateurRepository.findByNomUtilisateurOrEmail(utilisateurDTO.getNomUtilisateur(),utilisateurDTO.getEmail());
        if (utilisateur != null){
            if (utilisateur.getEmail().equals(utilisateurDTO.getEmail())) {
            throw new Exception("Email already in use");
        }
            if (utilisateur.getNomUtilisateur().equals(utilisateurDTO.getNomUtilisateur())){
                throw new Exception("Username already exists");
            }
        }
        return true;
    }
}
