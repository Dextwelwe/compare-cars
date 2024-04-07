package com.dextwelwe.carcomparaison;
import com.dextwelwe.carcomparaison.DTO.Users.ConnectionRequest;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTOGet;
import com.dextwelwe.carcomparaison.model.Users.Compte;
import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
import com.dextwelwe.carcomparaison.repository.UtilisateurRepository;
import com.dextwelwe.carcomparaison.service.Outils;
import com.dextwelwe.carcomparaison.service.UtilisateurService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UtilisateurServiceTests {
    @Mock
    private UtilisateurRepository utilisateurRepository;
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
    public void testSaveUtilisateur() throws Exception {
        Utilisateur utilisateur = new Utilisateur(12343, "null", "null", "null", new ArrayList<>(), "null");

        Utilisateur savedUtilisateur =  utilisateurService.saveUtilisateur(utilisateur.toDTO(utilisateur));

        assertNotNull(savedUtilisateur);

        verify(utilisateurRepository, times(1)).save(utilisateur);

    }

    @Test
    public void testSaveUtilisateurNull(){
        Utilisateur utilisateur = new Utilisateur(12343, null, "null", "null", new ArrayList<>(), "null");
        try {
            Utilisateur savedUtilisateur = (Utilisateur) utilisateurService.saveUtilisateur(utilisateur.toDTO(utilisateur));
            fail();
        } catch (Exception e){
            verify(utilisateurRepository, times(0)).save(utilisateur);
        }
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
    @Test
    public void testCheckUtilisateur() {
        Compte compte = new Compte(123,"user", "1234566789");
        Utilisateur compte1 = new Utilisateur(123,"email", "user", "1234566789",null, "abc");
        compte1.setRevues(null);
        Utilisateur compte2 = new Utilisateur(123,"email", "user", "1234566789",new ArrayList<>(), "abc");
        Outils outils = new Outils();
        boolean valnull = outils.anyFieldIsNull(compte);
        boolean valnull1 = outils.anyFieldIsNull(compte1);
        boolean valnull2 = outils.anyFieldIsNull(compte2);
        assertFalse(valnull);
        assertTrue(valnull1);
        assertFalse(valnull2);
    }
    @Test()
    public void testCreerUtilisateurNull(){
        // test passe si une erreur est trouve
        try {
            Utilisateur utilisateur = new Utilisateur(123, null, null, null, null, null);
            fail();
        } catch (Exception e){
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
