package com.dextwelwe.carcomparaison.DTO;
import com.dextwelwe.carcomparaison.model.Compte;
import com.dextwelwe.carcomparaison.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UtilisateurDTO extends CompteDto {
    private String email;
    private List<String> revues;
    private String preferences;
    private String characteristiques;
    public UtilisateurDTO(long id, String nomUtilisateur, String motDePasse, List<String> revues, String preferences, String characteristiques) {
        super(id, nomUtilisateur, motDePasse);
        this.revues = revues;
        this.preferences = preferences;
        this.characteristiques = characteristiques;
    }

    public Utilisateur fromDTO(UtilisateurDTO utilisateurDTO){
        return   new Utilisateur(
                utilisateurDTO.getId(),
                utilisateurDTO.getNomUtilisateur(),
                utilisateurDTO.getMotDePasse(),
                utilisateurDTO.revues,
                utilisateurDTO.getPreferences(),
                utilisateurDTO.getCharacteristiques());
    }
}
