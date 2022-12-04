package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.repository.impl.ManufacturerRepository;
import mk.ukim.finki.wp.lab.repository.jpa.ManufacturerRepositoryJPA;
import mk.ukim.finki.wp.lab.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepositoryJPA manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepositoryJPA manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer getManufacturerById(Long id) {
        if(id == null)
            throw new IllegalArgumentException();
        return manufacturerRepository.getManufacturerById (id);
    }
}
