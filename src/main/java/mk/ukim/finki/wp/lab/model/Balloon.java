package mk.ukim.finki.wp.lab.model;
import lombok.Data;

@Data
public class Balloon {
    private String name;
    private String description;
    private Long id;

    private Manufacturer manufacturer;

    public Balloon(String name, String description, Long id, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.manufacturer = manufacturer;
    }

}
