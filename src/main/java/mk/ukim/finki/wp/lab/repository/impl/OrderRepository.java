package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.Data.DataHolder;
import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    public List<Order> findAllBetween(LocalDateTime from, LocalDateTime to){
        return null;
    }

}
