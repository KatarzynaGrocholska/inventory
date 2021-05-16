package pl.project.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.inventory.entity.Wine;
import pl.project.inventory.repository.WineRepository;

import java.util.List;
import java.util.Optional;


@Service
public class WineServiceImp implements WineService{

    @Autowired
    private WineRepository wineRepository;

    public WineServiceImp(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    @Override
    public List<Wine> getAllWines() {
        return wineRepository.findAll();
    }

    @Override
    public void saveWine(Wine wine) {
this.wineRepository.save(wine);
    }

    @Override
    public Wine getWineById(Integer id) {
        Optional<Wine> optional= wineRepository.findById(id);
        Wine wine = null;
        if(optional.isPresent()){
            wine= optional.get();
        }else {
            throw new RuntimeException("Nie znaleziono takiego wina w bazie danych");
        }
        return wine;
    }


    @Override
    public void deleteWineByID(Integer id) {
this.wineRepository.deleteById(id);
    }
}
