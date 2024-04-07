package com.dextwelwe.carcomparaison.controlleurs;
import com.dextwelwe.carcomparaison.DTO.Users.ConnectionRequest;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTO;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTOGet;
import com.dextwelwe.carcomparaison.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/utilisateur")
@CrossOrigin(origins = "http://localhost:3000")
public class UtilisateurControlleur{
    private final UtilisateurService utilisateurService;
    @Autowired
    public UtilisateurControlleur(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    @PostMapping("/signUp")
    public ResponseEntity<String> createUpdateUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        try {
            utilisateurService.saveUtilisateur(utilisateurDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<UtilisateurDTOGet> connexion(@RequestBody ConnectionRequest connectionRequest) {
        UtilisateurDTOGet utilisateurDTOGet = null;
        try {
            utilisateurDTOGet = utilisateurService.getUtilisateurDTOGet(connectionRequest);
            return ResponseEntity.ok().body(utilisateurDTOGet);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
