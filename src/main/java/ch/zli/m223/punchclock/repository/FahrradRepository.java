package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Fahrrad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FahrradRepository extends JpaRepository<Fahrrad, Long> {

    @Query("from Fahrrad f left join fetch f.fahrradType left join fetch f.marke")
    List<Fahrrad> getAll();
}
