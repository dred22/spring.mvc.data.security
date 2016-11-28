package fr.treeptik.java.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.treeptik.java.models.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public Employee findOne(Integer id);
	public List<Employee> findAll();
}
