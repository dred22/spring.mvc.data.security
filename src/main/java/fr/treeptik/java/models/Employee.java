package fr.treeptik.java.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="employee")
public class Employee implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstName;
	@Enumerated(EnumType.STRING)
	private Status status;
	private String lastName; //nom
	private int salary;
	private Date startdate;
	@ManyToOne
	private Address address;
	@ManyToOne
	private Department department;
	
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + ", department="
				+ department + "]";
	}
	// TODO finir projects
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="employee_project",
				joinColumns=@JoinColumn(name="employee_id"),
				inverseJoinColumns = @JoinColumn(name="project_id"))
	private Set<Project> projects;
	@ManyToOne
	@JoinColumn(name="managed")
	private Employee managed;
	@OneToMany(mappedBy="managed")
    private Collection<Employee> children;
	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Employee getManaged() {
		return managed;
	}
	public void setManaged(Employee managed) {
		this.managed = managed;
	}
	public Collection<Employee> getChildren() {
		return children;
	}
	public void setChildren(Collection<Employee> children) {
		this.children = children;
	}
	public Employee() {
		projects = new HashSet<Project>();
	}
	public String firstName() {
		return firstName;
	}
	public void firstName(String name) {
		this.firstName = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Project projects) {
		this.projects.add(projects);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee(int id, String firstName, String lastName, int salary, Date startdate, Address address,
			Project projects, Employee managed, Status status, Department department) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.startdate = startdate;
		this.address = address;
		this.projects.add(projects);
		this.managed = managed;
		this.status = status;
		this.department = department;
	}

	
}
