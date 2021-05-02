package pl.project.inventory.service;

import pl.project.inventory.entity.Producer;
import java.util.List;

public interface ProducerService {
    List<Producer> getAllProducers();
    void saveProducer(Producer producer);
    Producer getProducerById(Integer id);
    void deleteProducerByID(Integer id);
}
