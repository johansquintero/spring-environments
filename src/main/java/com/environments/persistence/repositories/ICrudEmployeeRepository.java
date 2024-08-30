package com.environments.persistence.repositories;

import com.environments.persistentece.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ICrudEmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> findEmployeeById(Long id);
}
