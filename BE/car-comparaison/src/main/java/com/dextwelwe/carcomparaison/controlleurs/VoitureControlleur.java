package com.dextwelwe.carcomparaison.controlleurs;
import com.dextwelwe.carcomparaison.DTO.Voiture.VoitureDto;
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
    @GetMapping("/getModels")
    public ResponseEntity<List<String>> getAllModels(@RequestParam("make") String make) {
        return new ResponseEntity<>(voitureService.getListModels(make), HttpStatus.ACCEPTED);
    }
    @GetMapping("/getModelYears")
    public ResponseEntity<List<String>> getAllModelYears(@RequestParam("make") String make, @RequestParam("model") String model) {
        return new ResponseEntity<>(voitureService.getListModelYears(make,model), HttpStatus.ACCEPTED);
    }
    @GetMapping("/getTrims")
    public ResponseEntity<List<String>> getAllTrims(@RequestParam("make") String make, @RequestParam("model") String model,@RequestParam("year")String year) {
        return new ResponseEntity<>(voitureService.getListTrims(make,model,year), HttpStatus.ACCEPTED);
    }
    @GetMapping("/getCar")
    public ResponseEntity<VoitureDto> getCar(@RequestParam("id") long id) {
        try {
            return new ResponseEntity<>(voitureService.getCar(id), HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getCarId")
    public ResponseEntity<Long> getCarId(@RequestParam("make") String make, @RequestParam("model") String model, @RequestParam("year")String year, @RequestParam("trim")String version) {
        try {
            return new ResponseEntity<>(voitureService.getCarId(make, model, year, version), HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
