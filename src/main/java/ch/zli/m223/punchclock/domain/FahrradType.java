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
public class FahrradType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typ;

    public FahrradType(Long id, String typ) {
        this.id = id;
        this.typ = typ;
    }

    public FahrradType() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return typ;
    }

    public void setType(String type) {
        this.typ = typ;
    }
}
