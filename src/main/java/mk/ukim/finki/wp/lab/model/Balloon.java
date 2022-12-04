package mk.ukim.finki.wp.lab.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Balloon {
    private String name;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Manufacturer manufacturer;

    public Balloon(String name, String description, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public Balloon() {

    }
}
