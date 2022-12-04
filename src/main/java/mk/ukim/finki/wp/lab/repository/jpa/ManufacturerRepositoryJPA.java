package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepositoryJPA extends JpaRepository<Manufacturer,Long> {
    Manufacturer getManufacturerById(Long id);
}
