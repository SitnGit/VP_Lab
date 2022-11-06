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
        balloons.add(new Balloon("First","blue", 1L,new Manufacturer(1L,"first","Macedonia","adress")));
        balloons.add(new Balloon("Second","red",2L,new Manufacturer(2L,"second","Macedonia","adress")));
        balloons.add(new Balloon("Third","green",3L,new Manufacturer(3L,"third","Macedonia","adress")));
        balloons.add(new Balloon("Forth","yellow",4L,new Manufacturer(4L,"forth","Macedonia","adress")));
        balloons.add(new Balloon("Fifth","magenta",5L,new Manufacturer(5L,"fifth","Macedonia","adress")));
        balloons.add(new Balloon("Sixth","orange",6L,new Manufacturer(1L,"first","Macedonia","adress")));
        balloons.add(new Balloon("Seventh","cyan",7L,new Manufacturer(2L,"second","Macedonia","adress")));
        balloons.add(new Balloon("Eight","white",8L,new Manufacturer(3L,"third","Macedonia","adress")));
        balloons.add(new Balloon("Ninth","black",9L,new Manufacturer(4L,"forth","Macedonia","adress")));
        balloons.add(new Balloon("Tenth","pink",10L,new Manufacturer(5L,"fifth","Macedonia","adress")));

        manufacturers.add(new Manufacturer(1L,"first","Macedonia","adress"));
        manufacturers.add(new Manufacturer(2L,"second","Macedonia","adress"));
        manufacturers.add(new Manufacturer(3L,"third","Macedonia","adress"));
        manufacturers.add(new Manufacturer(4L,"forth","Macedonia","adress"));
        manufacturers.add(new Manufacturer(5L,"fifth","Macedonia","adress"));
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
