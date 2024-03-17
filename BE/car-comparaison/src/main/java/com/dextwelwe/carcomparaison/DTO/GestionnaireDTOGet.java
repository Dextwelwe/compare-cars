package com.dextwelwe.carcomparaison.DTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GestionnaireDTOGet extends CompteDto{
    public GestionnaireDTOGet(String nomUtilisateur){
        super(nomUtilisateur);
    }
}
