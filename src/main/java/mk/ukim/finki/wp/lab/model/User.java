package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="shop_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Convert(converter = PersonNameConverter.class)
    private PersonName personName;
    private String password;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "user")
    private List<ShoppingCart> carts;

    public User(String username, PersonName personName, String password, LocalDate dateOfBirth, List<ShoppingCart> carts) {
        this.username = username;
        this.password = password;
        this.personName = personName;
        this.dateOfBirth = dateOfBirth;
        this.carts = carts;
    }

    public User(String username) {
        this.username = username;
    }

    public User() {

    }
}
