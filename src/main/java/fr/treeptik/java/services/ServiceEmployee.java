package fr.treeptik.java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.java.interfaces.EmployeServiceInterface;
import fr.treeptik.java.models.Employee;
import fr.treeptik.java.repositories.EmployeeRepository;

@Service
public class ServiceEmployee implements EmployeServiceInterface {
	@Autowired
	private EmployeeRepository er;

	@Override
	public List<Employee> findAll() {
		 
		return er.findAll();
	}

	@Override
	public Employee findOne(Integer id) {
		
		return er.findOne(id);
	}



}
