package com.abhinavece.springsecurity.demo.config;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.abhinavece.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
		
	}
	
	// define a bean for security datasource
	
	@Bean
	public DataSource securityDataSource() {
		
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		logger.info(">>>>>> JDBC URL- "+ env.getProperty("jdbc.url"));
		logger.info(">>>>>> JDBC User- "+ env.getProperty("jdbc.user"));
		
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		securityDataSource.setInitialPoolSize(getIntPropertyValue(env.getProperty("connection.pool.initialPoolSize")));
		securityDataSource.setMinPoolSize(getIntPropertyValue(env.getProperty("connection.pool.minPoolSize")));
		securityDataSource.setMaxPoolSize(getIntPropertyValue(env.getProperty("connection.pool.maxPoolSize")));
		securityDataSource.setMaxIdleTime(getIntPropertyValue(env.getProperty("connection.pool.maxIdleTime")));
		
		return securityDataSource;
	}
	
	private int getIntPropertyValue(String propValue) {
				
		return Integer.parseInt(propValue);
	}
	
}
