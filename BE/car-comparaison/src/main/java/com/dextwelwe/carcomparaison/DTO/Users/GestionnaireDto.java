package com.dextwelwe.carcomparaison.DTO.Users;

import com.dextwelwe.carcomparaison.model.Users.Gestionnaire;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GestionnaireDto extends CompteDto {

    public GestionnaireDto(long id, String nomUtilisateur, String motDePasse){
        super(id,nomUtilisateur,motDePasse);
    }
    public Gestionnaire fromDTO(GestionnaireDto gestionnaireDto){
        return new Gestionnaire(
                gestionnaireDto.getId(),
                gestionnaireDto.getNomUtilisateur(),
                gestionnaireDto.getMotDePasse()
        );
    }
}
