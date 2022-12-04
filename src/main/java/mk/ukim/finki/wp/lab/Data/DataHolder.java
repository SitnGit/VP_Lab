package mk.ukim.finki.wp.lab.Data;


import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataHolder {
    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();

    @PostConstruct
    public void init(){
        balloons.add(new Balloon("First","blue", new Manufacturer("first","Macedonia","adress")));
        balloons.add(new Balloon("Second","red",new Manufacturer("second","Macedonia","adress")));
        balloons.add(new Balloon("Third","green",new Manufacturer("third","Macedonia","adress")));
        balloons.add(new Balloon("Forth","yellow",new Manufacturer("forth","Macedonia","adress")));
        balloons.add(new Balloon("Fifth","magenta",new Manufacturer("fifth","Macedonia","adress")));
        balloons.add(new Balloon("Sixth","orange",new Manufacturer("first","Macedonia","adress")));
        balloons.add(new Balloon("Seventh","cyan",new Manufacturer("second","Macedonia","adress")));
        balloons.add(new Balloon("Eight","white",new Manufacturer("third","Macedonia","adress")));
        balloons.add(new Balloon("Ninth","black",new Manufacturer("forth","Macedonia","adress")));
        balloons.add(new Balloon("Tenth","pink",new Manufacturer("fifth","Macedonia","adress")));

        manufacturers.add(new Manufacturer("first","Macedonia","adress"));
        manufacturers.add(new Manufacturer("second","Macedonia","adress"));
        manufacturers.add(new Manufacturer("third","Macedonia","adress"));
        manufacturers.add(new Manufacturer("forth","Macedonia","adress"));
        manufacturers.add(new Manufacturer("fifth","Macedonia","adress"));
    }

    public static Long generateId(){
        Random rand = new Random();

        long id = rand.nextLong(10000);

        for (Balloon b : balloons){
            if (b.getId() == id)
                generateId();
        }
        return id;
    }
}
