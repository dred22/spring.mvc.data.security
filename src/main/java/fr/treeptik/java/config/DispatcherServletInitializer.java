package fr.treeptik.java.config;

import javax.servlet.Filter;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {
	{
		
		System.out.println("DispatcherServletInitializer+++++++++++++++++++++++++");
	}
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { DataAccessConfig.class,
				WebMvcConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new HiddenHttpMethodFilter() };
	}
	
	

}
