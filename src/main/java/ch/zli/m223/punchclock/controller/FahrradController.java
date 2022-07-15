package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Fahrrad;
import ch.zli.m223.punchclock.service.FahrradService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fahrrads")
public class FahrradController {
    private FahrradService fahrradService;

    public FahrradController(FahrradService fahrradService) {
        this.fahrradService = fahrradService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Fahrrad> getAllFahrrads() {
        return fahrradService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fahrrad createFahrrad(@Valid @RequestBody Fahrrad fahrrad) {
        return fahrradService.createFahrrad(fahrrad);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFahrrad(@PathVariable long id) {
        fahrradService.deleteFahrrad(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Fahrrad updateFahrrad(@Valid @RequestBody Fahrrad fahrrad) {
        return fahrradService.updateFahrrad(fahrrad);
    }
}
