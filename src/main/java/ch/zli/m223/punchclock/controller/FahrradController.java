package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Fahrrad;
import ch.zli.m223.punchclock.service.FahrradService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Klasse: FahrradController
 * @author Tobias Sauter
 * @version 15.07.2022
 *
 * Der Fahrrad Controller stellt die Rest-Schnittstellen für die Applikation zur Verfügung,
 * um mit dem Client zu kommunizieren
 */

@RestController
@RequestMapping("/fahrrads")
public class FahrradController {
    private FahrradService fahrradService;

    //FahrradService im Controller implementieren umd auf den Service zugreifen können
    public FahrradController(FahrradService fahrradService) {
        this.fahrradService = fahrradService;
    }

    //Alle Fahrräder aus der Datenbank holen um im Frontend darzustellen
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Fahrrad> getAllFahrrads() {
        return fahrradService.findAll();
    }

    //Fahrrad erstellen
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fahrrad createFahrrad(@Valid @RequestBody Fahrrad fahrrad) {
        return fahrradService.createFahrrad(fahrrad);
    }

    //Fahrrad löschen
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFahrrad(@PathVariable long id) {
        fahrradService.deleteFahrrad(id);
    }

    //Fahrrad bearbeiten
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Fahrrad updateFahrrad(@Valid @RequestBody Fahrrad fahrrad) {
        return fahrradService.updateFahrrad(fahrrad);
    }
}
