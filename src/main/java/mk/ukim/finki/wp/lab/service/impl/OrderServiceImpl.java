package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Order;
import mk.ukim.finki.wp.lab.model.User;
import mk.ukim.finki.wp.lab.repository.jpa.OrderRepositoryJPA;
import mk.ukim.finki.wp.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepositoryJPA orderRepository;

    public OrderServiceImpl(OrderRepositoryJPA orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void placeOrder(String balloonColor, String username, String balloonSize, LocalDateTime localDateTime) {
        orderRepository.save(new Order(balloonColor,balloonSize,new User(username),localDateTime));
    }

    @Override
    public List<Order> listAll() {
        return orderRepository.findAll();

    }

}
