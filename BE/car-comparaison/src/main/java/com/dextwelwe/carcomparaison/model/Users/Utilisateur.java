package com.dextwelwe.carcomparaison.model.Users;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTO;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTOGet;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@NoArgsConstructor
@Entity
public class Utilisateur extends Compte {
   private String email;
   private List<String> revues;
   private String preferences;

    public Utilisateur(long id, String nomUtilisateur, String motDePasse, List<String> revues, String preferences) {
        super(id, nomUtilisateur, motDePasse);
        this.revues = revues;
        this.preferences = preferences;
    }
    public UtilisateurDTO toDTO(Utilisateur utilisateur){
        return new UtilisateurDTO(
                utilisateur.getId(),
                utilisateur.getNomUtilisateur(),
                utilisateur.getMotDePasse(),
                utilisateur.getRevues(),
                utilisateur.getPreferences()
        );
    }
    public UtilisateurDTOGet toDTOGet(Utilisateur utilisateur){
        return new UtilisateurDTOGet(
              utilisateur.getNomUtilisateur(),
              utilisateur.getRevues(),
              utilisateur.getPreferences()
        );
    }
}
