package fr.treeptik.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.treeptik.java.models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
