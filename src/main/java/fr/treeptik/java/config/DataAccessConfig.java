package fr.treeptik.java.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:/config.properties")
@ComponentScan(basePackages="fr.treeptik")
@EnableJpaRepositories("fr.treeptik.java.repositories")
public class DataAccessConfig {
	@Autowired
	private Environment environment;
	@Bean
	public DataSource dataSource() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getProperty("db.driverClassName"));
		System.out.println(environment.getProperty("db.url") +" driver is "+ environment.getProperty("db.driverClassName"));
		dataSource.setUrl(environment.getProperty("db.url"));
		dataSource.setUsername(environment.getProperty("db.username"));
		dataSource.setPassword(environment.getProperty("db.password"));
		System.out.println("DataSource OK");
		System.out.println(environment.getProperty("hibernate.hbm2ddl.auto"));
		return dataSource;
	}
	@Bean
	public PlatformTransactionManager transactionManager(
			EntityManagerFactory emf) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emf);
		return txManager;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);

		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);

		localContainerEntityManagerFactoryBean.setDataSource(dataSource());

		Properties properties = new Properties();
		properties.put("hibernate.generate_statistics", true);
		//!!!!!!!! database create mod
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));

		localContainerEntityManagerFactoryBean.setJpaProperties(properties);
		// à quoi sert @Repository???
		localContainerEntityManagerFactoryBean.setPackagesToScan("fr.treeptik.java.models");
		System.out.println("entity-manager ok");
		return localContainerEntityManagerFactoryBean;

	}

//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//		emf.setDataSource(dataSource());
//		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//		emf.setJpaPropertyMap(Collections.singletonMap(
//				"hibernate.session_factory_name", "mySessionFactory"));
//		return emf;
//	}

//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource(
//				"jdbc:mysql://localhost:3306/jpa_employee", "root", "root");
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		return dataSource;
//	}

}
