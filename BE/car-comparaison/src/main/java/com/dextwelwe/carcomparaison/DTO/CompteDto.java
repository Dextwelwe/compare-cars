package com.dextwelwe.carcomparaison.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompteDto {
    private long id;
    private String nomUtilisateur;
    private String motDePasse ;

    public CompteDto(String nomUtilisateur) {
    }
}
