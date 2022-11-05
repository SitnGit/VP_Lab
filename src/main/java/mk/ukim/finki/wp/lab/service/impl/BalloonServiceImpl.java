package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.repository.BalloonRepository;
import mk.ukim.finki.wp.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BalloonServiceImpl implements BalloonService {
    private final BalloonRepository balloonRep;

    public BalloonServiceImpl(BalloonRepository balloonRep) {
        this.balloonRep = balloonRep;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRep.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        if(text.isEmpty())
            throw new NullPointerException();
        return balloonRep.findAllByNameOrDescription(text);
    }
}
