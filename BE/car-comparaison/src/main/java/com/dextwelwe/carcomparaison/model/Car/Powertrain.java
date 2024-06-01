package com.dextwelwe.carcomparaison.model.Car;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Powertrain {
    String engine;
    String power;
    String torque;
    String induction;
    String fuelType;
    String transmission;
    String drivetrain;
    // ex. Gasoline Direct Injection
    String fuelSystem;

}
