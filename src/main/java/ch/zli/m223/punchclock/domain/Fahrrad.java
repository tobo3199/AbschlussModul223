package ch.zli.m223.punchclock.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Fahrrad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private FahrradType fahrradType;

    @ManyToOne
    private Marke marke;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FahrradType getFahrradType() {
        return fahrradType;
    }

    public void setFahrradType(FahrradType fahrradType) {
        this.fahrradType = fahrradType;
    }

    public Marke getMarke() {
        return marke;
    }

    public void setMarke(Marke marke) {
        this.marke = marke;
    }
}
