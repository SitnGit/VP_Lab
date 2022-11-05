package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.Data.DataHolder;
import mk.ukim.finki.wp.lab.model.Manufacturer;

import java.util.List;

public class ManufacturerRepository {
    public List<Manufacturer> findAll(){return DataHolder.manufacturers;
    }
}
