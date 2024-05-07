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

    public String getUserPreferences(String username){
        return utilisateurRepository.getUserPreferences(username);
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
    public void setUserPreferences(String username, String preferences) throws Exception {
        Utilisateur utilisateur = utilisateurRepository.findByNomUtilisateur(username);
        utilisateur.setPreferences(preferences);
        utilisateurRepository.save(utilisateur);
    }
}
