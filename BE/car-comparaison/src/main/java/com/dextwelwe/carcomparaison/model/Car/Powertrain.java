package com.dextwelwe.carcomparaison.model.Car;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Powertrain {
    String ENGINE;
    String POWER;
    String TORQUE;
    String INDUCTION;
    String FUEL_TYPE;
    String FUEL_SYSTEM;
    String TRANSMISSION;
    String DRIVETRAIN;

}
