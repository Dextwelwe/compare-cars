package com.dextwelwe.carcomparaison.model.Car;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
     Long id;
    @Embedded
    private General general;
    @Embedded
    private Efficiency efficiency;
    @Embedded
    private Acceleration acceleration;
    @Embedded
    private AdditionalInfo additionalInfo;
    @Embedded
    private Mechanical mechanical;
    @Embedded
    private Powertrain powertrain;
    @Embedded
    private Tech tech;
    @OneToOne()
    CarBasic carBasic;

}
