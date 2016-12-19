package fr.treeptik.tests;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fr.treeptik.java.models.Department;
import fr.treeptik.java.repositories.DepartmentRepository;
import fr.treeptik.java.services.impl.ServiceDepartment;

public class DepartmentServiceTest {
	
	protected DepartmentRepository dr;
	protected Department department;
	public ServiceDepartment serviceDepartment;
	
	@Before
	public void testJpaMock() {
		dr = createMock(DepartmentRepository.class);
		department = new Department();
		department.setName("Test_department");
		serviceDepartment = new ServiceDepartment();
		serviceDepartment.setDr(dr);
	}
	
	@Test
	public void testRepository() {
		
		assertTrue(serviceDepartment.getDr() instanceof DepartmentRepository);
	}
	
	@Test
	public void testSave() {
		expect(dr.save(department)).andReturn(department);
		replay(dr);
		serviceDepartment.save(department);
		verify(dr);
	}
	

}
