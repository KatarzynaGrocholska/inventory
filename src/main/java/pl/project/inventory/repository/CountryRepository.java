package pl.project.inventory.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.inventory.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
