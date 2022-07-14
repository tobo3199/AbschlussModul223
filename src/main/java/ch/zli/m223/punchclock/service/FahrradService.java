package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Fahrrad;
import ch.zli.m223.punchclock.repository.FahrradRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FahrradService {
    private FahrradRepository fahrradRepository;

    public FahrradService(FahrradRepository fahrradRepository) {
        this.fahrradRepository = fahrradRepository;
    }

    public Fahrrad createEntry(Fahrrad fahrrad) {
        return fahrradRepository.saveAndFlush(fahrrad);
    }

    public List<Fahrrad> findAll() {
        return fahrradRepository.findAll();
    }

    public void deleteEntry(long id) { fahrradRepository.deleteById(id); }
    
    public Fahrrad updateEntry(Fahrrad fahrrad) {
        return fahrradRepository.save(fahrrad);
    }
}
