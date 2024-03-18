package com.dextwelwe.carcomparaison.model.Users;
import com.dextwelwe.carcomparaison.DTO.Users.GestionnaireDTOGet;
import com.dextwelwe.carcomparaison.DTO.Users.GestionnaireDto;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@Entity
@ToString(callSuper = true)
public class Gestionnaire extends Compte {
    public Gestionnaire(long id, String nomUtilisateur, String motDePasse){
        super(id,nomUtilisateur,motDePasse);
    }
    public GestionnaireDto toDTO(Gestionnaire gestionnaire){
        return new GestionnaireDto(
                gestionnaire.getId(),
                gestionnaire.getNomUtilisateur(),
                gestionnaire.getMotDePasse()
        );
    }
    public GestionnaireDTOGet toDTOGet(Gestionnaire gestionnaire){
        return new GestionnaireDTOGet(
               gestionnaire.getNomUtilisateur()
        );
    }
}
