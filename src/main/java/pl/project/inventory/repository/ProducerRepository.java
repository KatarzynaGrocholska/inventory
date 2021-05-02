package pl.project.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.inventory.entity.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Integer> {
}
