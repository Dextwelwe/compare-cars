package com.dextwelwe.carcomparaison;
import com.dextwelwe.carcomparaison.repository.VoitureRepository;
import com.dextwelwe.carcomparaison.service.VoitureService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class VoitureServiceTests {
    private final VoitureRepository voitureRepository = Mockito.mock(VoitureRepository.class);
    @InjectMocks
    private VoitureService voitureService;

}
