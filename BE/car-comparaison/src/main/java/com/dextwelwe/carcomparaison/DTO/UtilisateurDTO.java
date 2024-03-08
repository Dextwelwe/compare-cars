package com.dextwelwe.carcomparaison.DTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
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
}
