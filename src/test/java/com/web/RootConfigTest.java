package com.web;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ RootConfig.class})
public class RootConfigTest {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	LocalSessionFactoryBean sessionFactoryBean;
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Test
	public void testDB(){
		
		assertNotNull(dataSource);
		
		assertNotNull(sessionFactoryBean);
		
		assertNotNull(sessionFactory);
		
		
	}
	
	

}
