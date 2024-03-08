package com.dextwelwe.carcomparaison.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class GestionnaireDto extends CompteDto{

    public GestionnaireDto(long id, String nomUtilisateur, String motDePasse){
        super(id,nomUtilisateur,motDePasse);
    }
}
