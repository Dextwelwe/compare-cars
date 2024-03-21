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
    private UtilisateurService utilisateurService;
    @Autowired
    public UtilisateurControlleur(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    @PostMapping
    public ResponseEntity<UtilisateurDTO> createUpdateUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        try {
            utilisateurService.saveUpdateUtilisateur(utilisateurDTO);
            return new ResponseEntity<>(utilisateurDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<UtilisateurDTO> connexion(@RequestBody ConnectionRequest connectionRequest) {
        UtilisateurDTOGet utilisateurDTOGet;
        try {
          utilisateurDTOGet = utilisateurService.getUtilisateurDTOGet(connectionRequest);
        } catch (Exception e){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
