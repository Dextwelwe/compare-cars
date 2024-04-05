package com.dextwelwe.carcomparaison.DTO.Users;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class CompteDtoGet {
    private long id;
    private String nomUtilisateur;
    public CompteDtoGet(long id,String nomUtilisateur) {
        this.id = id;
        this.nomUtilisateur = nomUtilisateur;
    }
}
