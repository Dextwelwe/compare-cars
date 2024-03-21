package com.dextwelwe.carcomparaison.model.Users;
import com.dextwelwe.carcomparaison.DTO.RevueDTO;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTO;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTOGet;
import com.dextwelwe.carcomparaison.model.Revue;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@ToString(callSuper = true)
public class Utilisateur extends Compte {
    @Column(unique = true)
    @NonNull
    private String email;
   @OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
   @ToString.Exclude
   private List<Revue> revues;
   @NonNull
   private String preferences;


    public Utilisateur(long id, String email, String nomUtilisateur, String motDePasse, List<Revue> revues, String preferences) {
        super(id, nomUtilisateur, motDePasse);
        this.email = email;
        if (revues != null) {
            this.revues = revues;
        } else {
            this.revues = new ArrayList<>();
        }
        this.preferences = preferences;
    }
    public UtilisateurDTO toDTO(Utilisateur utilisateur){

        return new UtilisateurDTO(
                utilisateur.getId(),
                utilisateur.getEmail(),
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
        if (revues != null) {
            for (Revue r : revues) {
                revuesDTO.add(r.toDTO(r));
            }
        }
        return revuesDTO;
    }
}
