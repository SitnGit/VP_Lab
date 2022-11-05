package mk.ukim.finki.wp.lab.model;

public class Manufacturer {

    private Long id;
    private String name;
    private String country;
    private String address;

    public Manufacturer(Long id, String name, String country, String address) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
    }
}
