package com.dextwelwe.carcomparaison.controlleurs;
import com.dextwelwe.carcomparaison.DTO.UtilisateurDTO;
import com.dextwelwe.carcomparaison.service.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/utilisateur")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UtilisateurControlleur {
    private UtilisateurService utilisateurService;
    @Autowired
    public UtilisateurControlleur(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    @PostMapping
    public ResponseEntity<UtilisateurDTO> createUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        try {
            utilisateurService.saveUtilisateur(utilisateurDTO.fromDTO(utilisateurDTO));
            return new ResponseEntity<>(utilisateurDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
