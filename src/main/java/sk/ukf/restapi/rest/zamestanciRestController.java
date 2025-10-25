package sk.ukf.restapi.rest;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.ukf.restapi.dto.ApiResponse;
import sk.ukf.restapi.entity.zamestanci;
import sk.ukf.restapi.service.zamestanciService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class zamestanciRestController {

    private zamestanciService zamestanciService;

    @Autowired
    public zamestanciRestController(zamestanciService zamestanciService) {
        this.zamestanciService = zamestanciService;
    }

    @GetMapping("/zamestanci")
    public ResponseEntity<ApiResponse<List<zamestanci>>> findAll() {
        List<zamestanci> zamestanci = zamestanciService.findAll();
        return ResponseEntity.ok(ApiResponse.success(zamestanci, "Úspešne načítané"));
    }

    @GetMapping("/zamestanci/{id}")
    public ResponseEntity<ApiResponse<zamestanci>> getZamestnanec(@PathVariable int id) {
        zamestanci zamestnanec = zamestanciService.findById(id);
        if (zamestnanec == null) {
            throw new RuntimeException("Zamestnanec id not found - " + id);
        }
        return ResponseEntity.ok(ApiResponse.success(zamestnanec, "Úspešne načítané"));
    }

    @PostMapping("/zamestanci")
    public ResponseEntity<ApiResponse<zamestanci>> addZamestnanec(@Valid @RequestBody zamestanci zamestnanec) {
        zamestnanec.setId(0);
        zamestanci zamestnanec_db = zamestanciService.save(zamestnanec);
        return ResponseEntity.ok(ApiResponse.success(zamestnanec_db, "Úspešne vytvorené"));
    }

    @PutMapping("/zamestanci/{id}")
    public ResponseEntity<ApiResponse<zamestanci>> updateZamestnanec(@PathVariable int id, @Valid @RequestBody zamestanci zamestnanec) {
        zamestanci existingZamestnanec = zamestanciService.findById(id);
        if (existingZamestnanec == null) {
            throw new RuntimeException("Zamestnanec id not found - " + id);
        }
        zamestnanec.setId(id);
        zamestanci zamestnanec_db = zamestanciService.save(zamestnanec);
        return ResponseEntity.ok(ApiResponse.success(zamestnanec_db, "Úspešne aktualizované"));
    }

    @DeleteMapping("/zamestanci/{id}")
    public ResponseEntity<ApiResponse<String>> deleteZamestnanec(@PathVariable int id) {
        zamestanci zamestnanec = zamestanciService.findById(id);
        if (zamestnanec == null) {
            throw new RuntimeException("Zamestnanec id not found - " + id);
        }
        zamestanciService.deleteById(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Úspešne vymazané"));
    }
}



