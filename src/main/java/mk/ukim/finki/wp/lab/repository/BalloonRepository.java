package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.Data.DataHolder;
import mk.ukim.finki.wp.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BalloonRepository {

    public List<Balloon> findAllBalloons() {
        return DataHolder.balloons;
    }

    public List<Balloon> findAllByNameOrDescription(String text){
        return DataHolder.balloons.stream().filter(balloon -> balloon.getName().contains(text) || balloon.getDescription().contains(text)).toList();
    }
}
