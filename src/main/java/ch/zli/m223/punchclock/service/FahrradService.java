package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Fahrrad;
import ch.zli.m223.punchclock.repository.FahrradRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Klasse: FahrradService
 * @author Tobias Sauter
 * @version 15.07.2022
 */

@Service
public class FahrradService {
    private FahrradRepository fahrradRepository;

    public FahrradService(FahrradRepository fahrradRepository) {
        this.fahrradRepository = fahrradRepository;
    }

    public Fahrrad createFahrrad(Fahrrad fahrrad) {
        return fahrradRepository.saveAndFlush(fahrrad);
    }

    public List<Fahrrad> findAll() {
        return fahrradRepository.getAll();
    }

    public void deleteFahrrad(long id) { fahrradRepository.deleteById(id); }
    
    public Fahrrad updateFahrrad(Fahrrad fahrrad) {
        return fahrradRepository.save(fahrrad);
    }
}
