package com.dextwelwe.carcomparaison.model.Car;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarBasic {
    @Id
    Long id;
    String MAKE;
    String MODEL;
    String YEAR_PRODUCTION;
    String TRIM;
    @OneToOne()
    @JoinColumn(name = "full_car_info_id")
    Car car;

}
