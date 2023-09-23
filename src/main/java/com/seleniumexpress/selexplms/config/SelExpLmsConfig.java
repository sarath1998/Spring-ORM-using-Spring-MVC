package com.seleniumexpress.selexplms.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com")
@EnableTransactionManagement  // Need this Annotation, when the TransactionManager needs to be enabled
public class SelExpLmsConfig implements WebMvcConfigurer{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory()
	{
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		// setting the datasource properties
		sessionFactoryBean.setDataSource(getDataSource());
		// setting the packages to scan
		sessionFactoryBean.setPackagesToScan("com.seleniumexpress.selexplms.entity");
		// setting the hibernate properties
		sessionFactoryBean.setHibernateProperties(getHibernateProperties());
		
		return sessionFactoryBean;  
	}
	
	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("root123");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/selenium-express");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager()
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();  
																							/* Introduced the Transaction Manager
																							   so that, no need to manually begin and commit the transaction
																							   inside the DB operating methods 
																							 */
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
	
	private Properties getHibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		
		return properties;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars1/**").addResourceLocations("/webjars/");
		registry.addResourceHandler("/URLToReachResourcesFolder/**").addResourceLocations("/resources/");
	}
	
}
