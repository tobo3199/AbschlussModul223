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

    private String type;

    public FahrradType(Long id, String type) {
        this.id = id;
        this.type = type;
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
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
