package com.environments.persistence.repositories;

import com.environments.persistentece.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class EmployeeRepository implements IEmployeeRepository{

    private final ICrudEmployeeRepository crudEmployeeRepository;

    @Override
    public List<Employee> getAll() {
        return (List<Employee>) this.crudEmployeeRepository.findAll();
    }

    @Override
    public Optional<Employee> save(Employee employee) {
        return Optional.of(this.crudEmployeeRepository.save(employee));
    }

    @Override
    public Optional<Employee> update(Employee employee) {
        if (this.crudEmployeeRepository.findEmployeeById(employee.getId()).isEmpty()){
            throw new RuntimeException("The employee doesn't exists");
        }
        return Optional.of(this.crudEmployeeRepository.save(employee));
    }

    @Override
    public Optional<Employee> getById(Long id) {
        return this.crudEmployeeRepository.findEmployeeById(id);
    }

    @Override
    public String delete(Long id) {
        if (this.crudEmployeeRepository.findEmployeeById(id).isEmpty()){
            throw new RuntimeException("The employee doesn't exists");
        }
        this.crudEmployeeRepository.deleteById(id);
        return "Empleado eliminado satisfactoriamente";
    }
}
