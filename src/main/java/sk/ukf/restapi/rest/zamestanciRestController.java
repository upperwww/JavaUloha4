package sk.ukf.restapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public List<zamestanci> findAll() {
        return zamestanciService.findAll();
    }

    @GetMapping("/zamestanci/{id}")
    public zamestanci getZamestnanec(@PathVariable int id) {

        zamestanci zamestnanec = zamestanciService.findById(id);

        if (zamestnanec == null) {
            throw new RuntimeException("Zamestnanec id not found - " + id);
        }

        return zamestnanec;
    }

    @PostMapping("/zamestanci")
    public zamestanci addZamestnanec(@RequestBody zamestanci zamestnanec) {
        zamestnanec.setId(0);
        zamestanci zamestnanec_db = zamestanciService.save(zamestnanec);
        return zamestnanec_db;
    }

    @PutMapping("/zamestanci/{id}")
    public zamestanci updateZamestnanec(@PathVariable int id, @RequestBody zamestanci zamestnanec) {
        zamestanci existingZamestnanec = zamestanciService.findById(id);
        if (existingZamestnanec == null) {
            throw new RuntimeException("Zamestnanec id not found - " + id);
        }
        zamestnanec.setId(id);
        zamestanci updatedZamestnanec = zamestanciService.save(zamestnanec);
        return updatedZamestnanec;
    }

    @DeleteMapping("/zamestanci/{id}")
    public String deleteZamestnanec(@PathVariable int id) {

        zamestanci zamestnanec = zamestanciService.findById(id);

        if (zamestnanec == null) {
            throw new RuntimeException("Zamestnanec id not found - " + id);
        }

        zamestanciService.deleteById(id);

        return "Deleted zamestnanec id - " + id;
    }

}
