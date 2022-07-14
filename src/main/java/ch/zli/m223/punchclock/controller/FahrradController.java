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
    public List<Fahrrad> getAllEntries() {
        return fahrradService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fahrrad createEntry(@Valid @RequestBody Fahrrad fahrrad) {
        return fahrradService.createEntry(fahrrad);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEntry(@PathVariable long id) {
        fahrradService.deleteEntry(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Fahrrad updateEntry(@Valid @RequestBody Fahrrad fahrrad) {
        return fahrradService.updateEntry(fahrrad);
    }
}
