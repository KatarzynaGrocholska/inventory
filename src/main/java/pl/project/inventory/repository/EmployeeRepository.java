package pl.project.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.inventory.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
