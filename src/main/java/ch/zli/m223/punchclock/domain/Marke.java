package ch.zli.m223.punchclock.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Klasse:
 *
 * @author: Tobias Sauter
 * @version:
 */
@Entity
public class Marke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String markenType;

    public Marke(){

    }

    public Marke(Long id, String markenType) {
        this.id = id;
        this.markenType = markenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarkenType() {
        return markenType;
    }

    public void setMarkenType(String markenType) {
        this.markenType = markenType;
    }
}
