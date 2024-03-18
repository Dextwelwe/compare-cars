package com.dextwelwe.carcomparaison.DTO.Users;
import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
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
    public UtilisateurDTO(long id, String nomUtilisateur, String motDePasse, List<String> revues, String preferences) {
        super(id, nomUtilisateur, motDePasse);
        this.revues = revues;
        this.preferences = preferences;
    }
    public Utilisateur fromDTO(UtilisateurDTO utilisateurDTO){
        return   new Utilisateur(
                utilisateurDTO.getId(),
                utilisateurDTO.getNomUtilisateur(),
                utilisateurDTO.getMotDePasse(),
                utilisateurDTO.getRevues(),
                utilisateurDTO.getPreferences()
               );
    }
}
