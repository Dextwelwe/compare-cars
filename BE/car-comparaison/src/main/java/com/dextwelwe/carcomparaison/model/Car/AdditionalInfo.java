package com.dextwelwe.carcomparaison.model.Car;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AdditionalInfo {
    String PROS;
    String CONS;
    String CAR_DESCRIPTION;

}
