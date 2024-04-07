package com.dextwelwe.carcomparaison.controlleurs;
import com.dextwelwe.carcomparaison.service.VoitureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voiture")
@CrossOrigin(origins = "http://localhost:3000")
public class VoitureControlleur {
    public final VoitureService voitureService;

    public VoitureControlleur(VoitureService voitureService) {
        this.voitureService = voitureService;
    }
    @GetMapping("/getMakes")
    public ResponseEntity<List<String>> getAllMakes() {
        return new ResponseEntity<>(voitureService.getListMakes(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/getModels")
    public ResponseEntity<List<String>> getAllModels(@RequestParam("make") String make) {
        return new ResponseEntity<>(voitureService.getListModels(make), HttpStatus.ACCEPTED);
    }

    @PostMapping("/getModelYears")
    public ResponseEntity<List<String>> getAllModelYears(@RequestParam("make") String make, @RequestParam("model") String model) {
        return new ResponseEntity<>(voitureService.getListModelYears(make,model), HttpStatus.ACCEPTED);
    }
}
