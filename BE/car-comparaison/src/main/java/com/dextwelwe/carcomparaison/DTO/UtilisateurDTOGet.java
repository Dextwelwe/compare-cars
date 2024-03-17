package com.dextwelwe.carcomparaison.DTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@NoArgsConstructor
@Data
public class UtilisateurDTOGet extends CompteDto{
    private String email;
    private List<String> revues;
    private String preferences;
    public UtilisateurDTOGet( String nomUtilisateur, List<String> revues, String preferences) {
        super(nomUtilisateur);
        this.revues = revues;
        this.preferences = preferences;
    }
}
