package com.environments.persistence.repositories;

import com.environments.persistentece.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeRepository {
    List<Employee> getAll();

    Optional<Employee> save(Employee employee);

    Optional<Employee> update(Employee employee);

    Optional<Employee> getById(Long id);

    String delete(Long id);
}
