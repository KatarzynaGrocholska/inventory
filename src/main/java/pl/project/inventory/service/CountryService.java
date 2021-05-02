package pl.project.inventory.service;

import pl.project.inventory.entity.Country;
import java.util.List;


public interface CountryService {
    List<Country> getAllCountries();
    void saveCountry(Country country);
    Country getCountryById(Integer id);
    void deleteCountryByID(Integer id);
}
