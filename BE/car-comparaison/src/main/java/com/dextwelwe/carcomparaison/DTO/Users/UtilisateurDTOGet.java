package com.dextwelwe.carcomparaison.DTO.Users;
import com.dextwelwe.carcomparaison.DTO.RevueDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@NoArgsConstructor
@Data
public class UtilisateurDTOGet extends CompteDto {
    private String email;
    private List<RevueDTO> revues;
    private String preferences;
    public UtilisateurDTOGet( String nomUtilisateur, List<RevueDTO> revues, String preferences) {
        super(nomUtilisateur);
        this.revues = revues;
        this.preferences = preferences;
    }

}
