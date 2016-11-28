package fr.treeptik.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.treeptik.java.models.Employee;
import fr.treeptik.java.services.ServiceEmployee;

@Controller
public class HelloController {
	@Autowired
	protected ServiceEmployee se;

	@RequestMapping("/hello")
	public String  hello(){
		System.out.println("Hello :)");
		Employee em = se.findOne(5);
		System.out.println(em);
		return "fake-page";
	}
	@RequestMapping("/show")
	public String  show(ModelMap model){
		Employee em = se.findOne(5);
		model.addAttribute("em", em);
		System.out.println("Show module ok ");
		return "show";
	}
	@RequestMapping("/show2")
	@ResponseBody
	public String  show2(){
		Employee em = se.findOne(5);
		
		
		return em.toString();
	}
	
}
