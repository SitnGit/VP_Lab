package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    void placeOrder(String balloonColor, String username, String balloonSize, LocalDateTime localDateTime);

    List<Order> listAll();
}
