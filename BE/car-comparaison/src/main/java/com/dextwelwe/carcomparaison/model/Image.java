package com.dextwelwe.carcomparaison.model;

import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
import com.dextwelwe.carcomparaison.model.Voiture.Voiture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image {
    @Id
    private long id;
    private String nomDeFichier;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Voiture voiture;
    @OneToOne
    private Utilisateur proprietaire;


}
