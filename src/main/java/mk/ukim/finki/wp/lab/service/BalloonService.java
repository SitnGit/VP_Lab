package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);

    Optional<Balloon> findById(Long id);
    void createBalloon(String name, String description, Manufacturer manufacturer);

    void deleteById(Long id);
}
