package com.dextwelwe.carcomparaison.model.Car;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Efficiency {
    String CITY;
    String HIGHWAY;
    String MIXED;
    String AUTONOMY;
}
