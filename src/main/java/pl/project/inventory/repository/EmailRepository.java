package pl.project.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.project.inventory.entity.Wine;

import java.util.List;

public interface EmailRepository extends JpaRepository<Wine, Integer> {

    @Query("SELECT w from Wine w where w.amount <= w.monthly")
    List<Wine> getWineByAmount(String name);
}

