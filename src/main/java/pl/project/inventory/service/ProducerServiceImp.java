package pl.project.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.inventory.entity.Producer;
import pl.project.inventory.repository.ProducerRepository;
import java.util.List;
import java.util.Optional;


@Service
public class ProducerServiceImp implements ProducerService {

@Autowired
private ProducerRepository producerRepository;

    public ProducerServiceImp(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @Override
    public List<Producer> getAllProducers() {
        return producerRepository.findAll();
    }

    @Override
    public void saveProducer(Producer producer) {
        this.producerRepository.save(producer);
    }

    @Override
    public Producer getProducerById(Integer id) {
        Optional<Producer> optional= producerRepository.findById(id);
        Producer producer = null;
        if(optional.isPresent()){
            producer= optional.get();
        }else {
            throw new RuntimeException("Nie znaleziono takiego producenta w bazie danych");
        }
        return producer;
    }

    @Override
    public void deleteProducerByID(Integer id) {
        this.producerRepository.deleteById(id);
    }
}
