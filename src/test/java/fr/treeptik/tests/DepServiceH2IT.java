package fr.treeptik.tests;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import antlr.collections.List;
import fr.treeptik.java.config.DataAccessConfig;
import fr.treeptik.java.models.Department;
import fr.treeptik.java.services.DepartmentServiceInterface;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matcher;
import org.hamcrest.core.IsEqual;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {DataAccessConfig.class})
public class DepServiceH2IT {
//	@Autowired
//	protected DepartmentRepository dr;
	@Autowired
	protected DepartmentServiceInterface serviceDepartment;
	
	@Test
	public void testSeve() {
		Department department = new Department();
		department.setName("Test_department");
		Department savedDep = serviceDepartment.save(department);
		assertThat(savedDep, instanceOf(Department.class));
		assertThat(savedDep.getName(),equalTo("Test_department") );
		System.out.println(department);
		
	}
//	@Test
//	public void testGet() {
//		//Department department = new Department();
//		
//		List<Department> departments = serviceDepartment.findAll();
//		System.out.println("mmmmmmmmmmmmmmmmmmmmmmm");
//		System.out.println(department);
//		//assertThat(savedDep, instanceOf(Department.class));
//		//assertThat(savedDep.getName(),equalTo("Test_department") );
//		
//	}


}
