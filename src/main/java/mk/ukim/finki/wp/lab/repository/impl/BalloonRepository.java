package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.Data.DataHolder;
import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BalloonRepository {

    public List<Balloon> findAllBalloons() {
        return DataHolder.balloons;
    }

    public List<Balloon> findAllByNameOrDescription(String text){
        return DataHolder.balloons.stream().filter(balloon -> balloon.getName().contains(text) || balloon.getDescription().contains(text)).toList();
    }

    public void createBalloon(String name, String description, Manufacturer manufacturer){
        DataHolder.balloons.removeIf(b->b.getName().equals(name));
        DataHolder.balloons.add(new Balloon(name,description,manufacturer));
    }

    public void deleteById(Long id){
        DataHolder.balloons.removeIf(b->b.getId().equals(id));
    }

    public Optional<Balloon> findById(Long id){
        return DataHolder.balloons.stream().filter(b->b.getId().equals(id)).findFirst();
    }
}
