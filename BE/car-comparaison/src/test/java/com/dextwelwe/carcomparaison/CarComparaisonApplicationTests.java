package com.dextwelwe.carcomparaison;
import com.dextwelwe.carcomparaison.DTO.Users.ConnectionRequest;
import com.dextwelwe.carcomparaison.DTO.Users.UtilisateurDTOGet;
import com.dextwelwe.carcomparaison.model.Users.Utilisateur;
import com.dextwelwe.carcomparaison.repository.UtilisateurRepository;
import com.dextwelwe.carcomparaison.service.UtilisateurService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CarComparaisonApplicationTests {
	@Mock
	private UtilisateurRepository utilisateurRepository;
	@InjectMocks
	private UtilisateurService utilisateurService;
	@Test
	public void testGetUtilisateurDTOGet() throws Exception {
		ConnectionRequest connectionRequest = new ConnectionRequest();

		connectionRequest.setNomUtilisateur("username");
		connectionRequest.setMotDePasse("password");

		Utilisateur utilisateur = new Utilisateur();

		utilisateur.setNomUtilisateur("username");
		utilisateur.setMotDePasse("password");

		when(utilisateurRepository.findByNomUtilisateur("username")).thenReturn(utilisateur);

		UtilisateurDTOGet utilisateurDTOGet = utilisateurService.getUtilisateurDTOGet(connectionRequest);

		UtilisateurDTOGet utilisateurDTOGet1 = new UtilisateurDTOGet("abc", null, "123");
		System.out.println(utilisateurDTOGet1);
		System.out.println(utilisateurDTOGet);
		assertNotNull(utilisateurDTOGet);
		System.out.println(utilisateurDTOGet.getNomUtilisateur());

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
}
