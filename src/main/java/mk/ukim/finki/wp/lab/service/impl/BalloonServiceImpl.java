package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.repository.impl.BalloonRepository;
import mk.ukim.finki.wp.lab.repository.jpa.BalloonRepositoryJPA;
import mk.ukim.finki.wp.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {
    private final BalloonRepositoryJPA balloonRep;

    public BalloonServiceImpl(BalloonRepositoryJPA balloonRep) {
        this.balloonRep = balloonRep;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRep.findAll();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        if(text.isEmpty())
            throw new NullPointerException();
        return balloonRep.findAllByNameOrDescriptionLike (text,text);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        if(id == null)
            throw new IllegalArgumentException();
        return balloonRep.findById(id);
    }

    @Override
    public void createBalloon(String name, String description, Manufacturer manufacturer) {
        if(name == null || description == null || manufacturer == null)
            throw new IllegalArgumentException();
        balloonRep.save(new Balloon(name,description,manufacturer));
    }

    @Override
    public void deleteById(Long id) {
        if(id == null)
            throw new IllegalArgumentException();
        balloonRep.deleteById(id);
    }
}
