package com.dextwelwe.carcomparaison;
import com.dextwelwe.carcomparaison.DTO.Users.ConnectionRequest;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTOGet;
import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
import com.dextwelwe.carcomparaison.repository.UtilisateurRepository;
import com.dextwelwe.carcomparaison.service.UtilisateurService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UtilisateurServiceTests {
    private final UtilisateurRepository utilisateurRepository = Mockito.mock(UtilisateurRepository.class);
    @InjectMocks
    private UtilisateurService utilisateurService;
    @Test
    public void testGetUtilisateurDTOGet() throws Exception {
        ConnectionRequest connectionRequest = new ConnectionRequest();
        Utilisateur utilisateur = new Utilisateur();

        connectionRequest.setNomUtilisateur("username");
        connectionRequest.setMotDePasse("password");
        utilisateur.setNomUtilisateur("username");
        utilisateur.setMotDePasse("password");

        when(utilisateurRepository.findByNomUtilisateur("username")).thenReturn(utilisateur);

        UtilisateurDTOGet utilisateurDTOGet = utilisateurService.getUtilisateurDTOGet(connectionRequest);

        assertNotNull(utilisateurDTOGet);

        assertEquals("username", utilisateurDTOGet.getNomUtilisateur());

        verify(utilisateurRepository, times(1)).findByNomUtilisateur("username");
    }
    @Test
    public void testGetUtilisateurDTOGetIncorrectPassword() {
        ConnectionRequest connectionRequest = new ConnectionRequest();
        connectionRequest.setNomUtilisateur("username");
        connectionRequest.setMotDePasse("passssword");

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNomUtilisateur("username");
        utilisateur.setMotDePasse("password");

        when(utilisateurRepository.findByNomUtilisateur("username")).thenReturn(utilisateur);

        assertThrows(Exception.class, () -> {
            utilisateurService.getUtilisateurDTOGet(connectionRequest);
        });
        verify(utilisateurRepository, times(1)).findByNomUtilisateur("username");
    }

    @Test
    public void testGetUtilisateurDTOGetEmptyUsername() {
        ConnectionRequest connectionRequest = new ConnectionRequest();
        connectionRequest.setNomUtilisateur("");
        connectionRequest.setMotDePasse("password");

        assertThrows(Exception.class, () -> {
            utilisateurService.getUtilisateurDTOGet(connectionRequest);
        });
    }

    @Test()
    public void testCreerUtilisateurNull(){
        // test passe si une erreur est trouve
        try {
            Utilisateur utilisateur = new Utilisateur(123, null, null, null, null, null);
            fail();
        } catch (Exception ignored){
        }
    }
    @Test()
    public void testCreerUtilisateur(){
        try {
            Utilisateur utilisateur = new Utilisateur(123, "null", "null", "null", new ArrayList<>(), "null");
        } catch (Exception e){
            fail();
        }
    }


}
