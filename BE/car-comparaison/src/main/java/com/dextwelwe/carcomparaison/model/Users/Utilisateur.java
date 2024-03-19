package com.dextwelwe.carcomparaison.model.Users;
import com.dextwelwe.carcomparaison.DTO.RevueDTO;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTO;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTOGet;
import com.dextwelwe.carcomparaison.model.Revue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@Entity
public class Utilisateur extends Compte {
   private String email;
   @OneToMany
   private List<Revue> revues;
   private String preferences;

    public Utilisateur(long id, String nomUtilisateur, String motDePasse, List<Revue> revues, String preferences) {
        super(id, nomUtilisateur, motDePasse);
        this.revues = revues;
        this.preferences = preferences;
    }
    public UtilisateurDTO toDTO(Utilisateur utilisateur){

        return new UtilisateurDTO(
                utilisateur.getId(),
                utilisateur.getNomUtilisateur(),
                utilisateur.getMotDePasse(),
                getRevuesDTO(),
                utilisateur.getPreferences()
        );
    }
    public UtilisateurDTOGet toDTOGet(Utilisateur utilisateur){
        return new UtilisateurDTOGet(
              utilisateur.getNomUtilisateur(),
              utilisateur.getRevuesDTO(),
              utilisateur.getPreferences()
        );
    }
    @Transient
    private List<RevueDTO> getRevuesDTO() {
        List<RevueDTO> revuesDTO = new ArrayList<>();
        for (Revue r : revues) {
            revuesDTO.add(r.toDTO(r));
        }
        return revuesDTO;
    }
}
