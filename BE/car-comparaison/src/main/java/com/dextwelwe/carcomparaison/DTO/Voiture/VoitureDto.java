package com.dextwelwe.carcomparaison.DTO.Voiture;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class VoitureDto {
    @Id
    private long id;
    private String marque;
    private String annee;
    private String version;
    private String description;
}
