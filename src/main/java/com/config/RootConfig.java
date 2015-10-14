package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan(basePackages="com",
excludeFilters={
		@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
})
@EnableTransactionManagement
public class RootConfig {
	
	
	@Bean
	public DataSource dataSource(){
		/*BasicDataSource dataSource = new BasicDataSource();*/
		/*SimpleDriverDataSource dataSource = new SimpleDriverDataSource();*/
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydatabase");
		return dataSource;
	}

	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
		LocalSessionFactoryBean localSessionFactoryBean=
				new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource);
		
		localSessionFactoryBean.setPackagesToScan("com");
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		localSessionFactoryBean.setHibernateProperties(hibernateProperties);
		
		return localSessionFactoryBean;
	}

	
	@Bean
	public HibernateTransactionManager transactionManager(DataSource dataSource, SessionFactory sessionFactory){
		HibernateTransactionManager txManager = 
				new HibernateTransactionManager();	
		txManager.setSessionFactory(sessionFactory);
		/*txManager.setDataSource(dataSource);*/
		return txManager;
	}
	
}
