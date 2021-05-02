package pl.project.inventory.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.project.inventory.entity.Employee;
import pl.project.inventory.repository.EmployeeRepository;
import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {


        @Autowired
        private EmployeeRepository employeeRepository;

        public EmployeeController(EmployeeRepository employeeRepository) {
            this.employeeRepository = employeeRepository;
        }

        @GetMapping("/list")
        public List<Employee> list(){
            return employeeRepository.findAll();
        }

        @GetMapping("/{id}")
        public Employee get(@PathVariable Integer id){
            return employeeRepository.getOne(id);
        }

        @PostMapping("/add")
        public Employee create(@RequestBody Employee employee){
            return  employeeRepository.saveAndFlush(employee);
        }


        @RequestMapping(value ="/delete/{id}")
        public void delete(@PathVariable Integer id){

            employeeRepository.deleteById(id);

        }

        @RequestMapping(value ="/edit/{id}")
        public Employee update(@PathVariable Integer id, @RequestBody Employee employee){
            Employee existingEmployee = employeeRepository.getOne(id);
            BeanUtils.copyProperties(employee , existingEmployee, "employee_id");
            return employeeRepository.saveAndFlush(employee);
        }

}
