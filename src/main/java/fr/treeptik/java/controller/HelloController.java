package fr.treeptik.java.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.treeptik.java.models.Department;
import fr.treeptik.java.models.Employee;
import fr.treeptik.java.services.DepartmentServiceInterface;
import fr.treeptik.java.services.EmployeServiceInterface;

@Controller
@SessionAttributes("toggled")
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
//	@RequestMapping("/toggle")
//	@ResponseBody
//	public String  toggle(HttpSession session ){
//		//session.setAttribute("toggled", "toggled");
//		
//		String toggled = (String) session.getAttribute("toggled");
//		System.out.println(toggled);
//		
//		if(toggled.equals("toggled")){
//			toggled = "4";
//		} else {
//			toggled = "toggled";
//		}
//		session.removeValue("toggled");
//		//session.setAttribute("toggled", toggled);
//		return "{"+toggled+"}";
//	}
	
	/*	public String  toggle(@ModelAttribute("toggled") String toggled){
		System.out.println(toggled);
		
		if(toggled.equals("toggled")){
			toggled = "";
		} else {
			toggled = "toggled";
		}
		
		return "{"+toggled+"}";
	}*/
	
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
	@RequestMapping("/show-all")
	public String  showAll(ModelMap model){
		List<Employee> em = se.findAll();
		model.addAttribute("em", em);
		return "show-all";
	}
	@RequestMapping( path = "/create", method = RequestMethod.GET)
	public String  getCreate(ModelMap model){

		model.addAttribute("employee", new Employee());
		return "create";
	}
	@RequestMapping( path = "/create", method = RequestMethod.POST)
	public String  postCreate(@ModelAttribute("employee") Employee employee, ModelMap model){
//	      model.addAttribute("firstName", employee.firstName());
//	      model.addAttribute("lastName", employee.lastName());
//	      model.addAttribute("salary", employee.salary());
		employee = se.save(employee);
		System.out.println("POOOOOOOSTED "+employee);
		return "create";
	}
	
}
