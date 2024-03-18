package com.dextwelwe.carcomparaison.DTO.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ConnectionRequest {
    String motDePasse;
    String nomUtilisateur;
}
