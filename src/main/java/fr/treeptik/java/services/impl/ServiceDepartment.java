package fr.treeptik.java.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.java.models.Department;
import fr.treeptik.java.repositories.DepartmentRepository;
import fr.treeptik.java.services.DepartmentServiceInterface;
@Service
public class ServiceDepartment implements DepartmentServiceInterface {
	@Autowired
	protected DepartmentRepository dr;
	
	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return dr.findAll();
	}

	@Override
	public Department findOne(Integer id) {
		// TODO Auto-generated method stub
		return dr.findOne(id);
	}

	@Override
	public Department save(Department obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
