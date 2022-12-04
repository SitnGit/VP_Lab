package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="orders")
public class Order {
    private String balloonColor;
    private String balloonSize;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime placedAt;
    @ManyToOne(cascade = CascadeType.ALL) // this allows adding new Orders to db without adding the User
    private User user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    public Order(String balloonColor, String balloonSize, User user,LocalDateTime placedAt) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.user = user;
        this.placedAt = placedAt;
    }

    public Order() {

    }
}
