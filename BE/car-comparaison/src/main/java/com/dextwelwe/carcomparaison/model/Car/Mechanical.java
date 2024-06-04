package com.dextwelwe.carcomparaison.model.Car;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Mechanical {
    String STEERING;
    String FRONT_BRAKES;
    String REAR_BRAKES;
    String FRONT_TIRES;
    String REAR_TIRES;
    String TOWING_CAPACITY;
    String FUEL_TANK;
    String TRUNK_VOLUME;
}
