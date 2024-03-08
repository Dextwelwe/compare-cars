package com.dextwelwe.carcomparaison.model;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper = true)
public class Gestionnaire extends Compte{
    public Gestionnaire(long id, String nomUtilisateur, String motDePasse){
        super(id,nomUtilisateur,motDePasse);
    }
}
