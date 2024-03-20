package com.dextwelwe.carcomparaison.model.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.*;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class Compte {
    @Id
    private long id;
    private String nomUtilisateur;
    private String motDePasse ;
}