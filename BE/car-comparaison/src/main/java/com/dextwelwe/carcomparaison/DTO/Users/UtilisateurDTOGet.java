package com.dextwelwe.carcomparaison.DTO.Users;
import com.dextwelwe.carcomparaison.DTO.RevueDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
public class UtilisateurDTOGet extends CompteDtoGet {
    private List<RevueDTO> revues;
    private String preferences;
    public UtilisateurDTOGet(long id ,String nomUtilisateur, List<RevueDTO> revues, String preferences) {
        super(id,nomUtilisateur);
        this.revues = revues;
        this.preferences = preferences;
    }

}
