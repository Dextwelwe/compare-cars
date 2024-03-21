package com.dextwelwe.carcomparaison.model.Users;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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