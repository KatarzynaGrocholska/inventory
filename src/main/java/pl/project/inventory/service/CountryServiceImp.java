package pl.project.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.inventory.entity.Country;
import pl.project.inventory.repository.CountryRepository;
import java.util.List;
import java.util.Optional;


@Service
public class CountryServiceImp implements CountryService{

    @Autowired
    private CountryRepository countryRepository;
    public CountryServiceImp(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public void saveCountry(Country country) {
        this.countryRepository.save(country);
    }

    @Override
    public Country getCountryById(Integer id) {
        Optional<Country> optional= countryRepository.findById(id);
        Country country = null;
        if(optional.isPresent()){
            country= optional.get();
        }else {
            throw new RuntimeException("Nie znaleziono takiego kraju w bazie danych");
        }
        return country;
    }

    @Override
    public void deleteCountryByID(Integer id) {
this.countryRepository.deleteById(id);
    }
}
