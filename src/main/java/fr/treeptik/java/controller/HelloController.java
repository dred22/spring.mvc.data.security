package fr.treeptik.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.treeptik.java.models.Department;
import fr.treeptik.java.models.Employee;
import fr.treeptik.java.services.DepartmentServiceInterface;
import fr.treeptik.java.services.EmployeServiceInterface;

@Controller
public class HelloController {
	@Autowired
	protected EmployeServiceInterface se;
	
	@Autowired
	protected DepartmentServiceInterface sd;

	@RequestMapping("/hello")
	public String  hello(){
		System.out.println("Hello :)");
		Employee em = se.findOne(5);
		System.out.println(em);
		return "fake-page";
	}
	@RequestMapping("/show")
	public String  show(ModelMap model){
		List<Employee> em = se.findAll();
		model.addAttribute("em", em);
		
		System.out.println("Show module ok ");
		System.out.println(em);
		return "show";
	}
	@RequestMapping("/show2")
	@ResponseBody
	public String  show2(){
		Employee em = se.findOne(5);
		
		
		return em.toString();
	}
	@RequestMapping("/showdepartment")
	public String  showDepartment(ModelMap model){
		List<Department> em = sd.findAll();
		model.addAttribute("em", em);
		
		System.out.println("Department module ok ");
		System.out.println(em);
		return "show";
	}
	
	
	@RequestMapping("/")
	public String  index(){
		System.out.println("index");
		return "index";
	}
	
}
