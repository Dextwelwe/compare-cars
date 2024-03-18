package com.dextwelwe.carcomparaison.model.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
@Entity
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