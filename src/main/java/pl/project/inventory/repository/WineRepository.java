package pl.project.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.inventory.entity.Wine;

public interface WineRepository extends JpaRepository<Wine, Integer> {
}
