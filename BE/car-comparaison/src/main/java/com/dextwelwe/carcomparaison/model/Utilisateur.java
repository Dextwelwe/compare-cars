package com.dextwelwe.carcomparaison.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@NoArgsConstructor
public class Utilisateur extends Compte{
   private String email;
   private List<String> revues;
   private String preferences;
   private String characteristiques;
    public Utilisateur(long id, String nomUtilisateur, String motDePasse, List<String> revues, String preferences, String characteristiques) {
        super(id, nomUtilisateur, motDePasse);
        this.revues = revues;
        this.preferences = preferences;
        this.characteristiques = characteristiques;
    }
}
