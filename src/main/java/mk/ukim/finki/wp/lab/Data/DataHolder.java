package mk.ukim.finki.wp.lab.Data;


import mk.ukim.finki.wp.lab.model.Balloon;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataHolder {
    public static List<Balloon> balloons = new ArrayList<>();

    @PostConstruct
    public void init(){
        balloons.add(new Balloon("First","blue"));
        balloons.add(new Balloon("Second","red"));
        balloons.add(new Balloon("Third","green"));
        balloons.add(new Balloon("Forth","yellow"));
        balloons.add(new Balloon("Fifth","magenta"));
        balloons.add(new Balloon("Sixth","orange"));
        balloons.add(new Balloon("Seventh","cyan"));
        balloons.add(new Balloon("Eight","white"));
        balloons.add(new Balloon("Ninth","black"));
        balloons.add(new Balloon("Tenth","pink"));

    }

}
