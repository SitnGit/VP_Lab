package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateCreated;
    @ManyToMany
    private List<Order> orders;

    public ShoppingCart(User user, List<Order> orders) {
        this.user = user;
        this.dateCreated = LocalDateTime.now();
        this.orders = orders;
    }

    public ShoppingCart() {
        this.dateCreated = LocalDateTime.now();
    }
}
