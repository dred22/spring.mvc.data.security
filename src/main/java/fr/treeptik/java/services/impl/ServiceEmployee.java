package fr.treeptik.java.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.java.models.Employee;
import fr.treeptik.java.repositories.EmployeeRepository;
import fr.treeptik.java.services.EmployeServiceInterface;

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

	@Override
	public Employee save(Employee obj) {
		return er.save(obj);
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		er.delete(id);
	}



}
