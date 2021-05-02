package pl.project.inventory.service;



import pl.project.inventory.entity.Wine;

import java.util.List;

public interface WineService {
    List<Wine> getAllWines();
    void saveWine(Wine wine);
    Wine getWineById(Integer id);
    void deleteWineByID(Integer id);
}
