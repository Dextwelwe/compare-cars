package com.dextwelwe.carcomparaison.DTO.Users;
import com.dextwelwe.carcomparaison.DTO.RevueDTO;
import com.dextwelwe.carcomparaison.model.Revue;
import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UtilisateurDTO extends CompteDto {
    private String email;
    private List<RevueDTO> revues;
    private String preferences;
    public UtilisateurDTO(long id, String email, String nomUtilisateur, String motDePasse, List<RevueDTO> revues, String preferences) {
        super(id, nomUtilisateur, motDePasse);
        this.email = email;
        this.revues = Objects.requireNonNullElseGet(revues, ArrayList::new);
        this.preferences = preferences;
    }
    public Utilisateur fromDTO(UtilisateurDTO utilisateurDTO){
        List<Revue> revues = new ArrayList<>();
        for (int i = 0; i < getRevues().size(); i++){
            revues.add(getRevues().get(i).fromDTO(getRevues().get(i)));
        }
        return   new Utilisateur(
                utilisateurDTO.getId(),
                utilisateurDTO.getEmail(),
                utilisateurDTO.getNomUtilisateur(),
                utilisateurDTO.getMotDePasse(),
                revues,
                utilisateurDTO.getPreferences()
               );
    }

    public List<RevueDTO> getRevues() {
        return Objects.requireNonNullElseGet(revues, ArrayList::new);
    }
}
