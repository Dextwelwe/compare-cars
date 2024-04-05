package com.dextwelwe.carcomparaison.DTO.Users;
import com.dextwelwe.carcomparaison.DTO.Users.CompteDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GestionnaireDTOGet extends CompteDtoGet {
    public GestionnaireDTOGet(long id,String nomUtilisateur){
        super(id,nomUtilisateur);
    }
}
