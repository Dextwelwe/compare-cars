package com.dextwelwe.carcomparaison.model.Car;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class General {
    String MSRP;
    String VEHICULE_TYPE;
    String ASSEMBLY;
    String LENGTH;
    String WIDTH;
    String HEIGHT;
    String WEIGHT;
}
