package com.dextwelwe.carcomparaison.model.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.lang.NonNull;
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
    @NonNull
    @Size(min=5)
    @Size(max = 50)
    private String nomUtilisateur;
    @NonNull
    @Size(min=8)
    @Size(max=50)
    private String motDePasse ;
}