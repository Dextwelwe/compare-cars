package com.dextwelwe.carcomparaison.model;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Entity
@ToString(callSuper = true)
public class Gestionnaire extends Compte{
    public Gestionnaire(long id, String nomUtilisateur, String motDePasse){
        super(id,nomUtilisateur,motDePasse);
    }
}
