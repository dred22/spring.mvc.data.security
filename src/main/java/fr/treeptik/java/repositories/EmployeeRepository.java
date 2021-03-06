package fr.treeptik.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.treeptik.java.models.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
