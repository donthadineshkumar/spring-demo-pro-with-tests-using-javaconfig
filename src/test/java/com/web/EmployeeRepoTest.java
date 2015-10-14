package com.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.config.RootConfig;
import com.model.Employee;
import com.repository.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = {RootConfig.class, EmployeeRepository.class} )
public class EmployeeRepoTest {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Test
	public void findEmployee(){
		Employee emp =employeeRepository.findEmployee(1);
		assertNotNull(emp);
		System.out.println(emp.getSalary());
		assertEquals("dinesh", emp.getName());		
	}
	
	@Test
	public void testSave(){
		Employee emp1 = new Employee();
		emp1.setName("manju");
		emp1.setDept("java");
		emp1.setSalary(new Double(565.34));
		
		Employee emp2 = employeeRepository.saveEmployee(emp1);
		
		System.out.println(emp2.getEmpno());
		assertEquals(new Integer(2), emp2.getEmpno());		
	}
	
	@Test
	public void testEdit(){
		
		Employee emp1 = new Employee();
		emp1.setEmpno(new Integer(2));
		emp1.setName("Varsha");
		emp1.setDept("ROR");
		emp1.setSalary(new Double(565.34));
		
		employeeRepository.updateEmployee(emp1);
		Employee emp = employeeRepository.findEmployee(2);
		System.out.println(emp.getDept());
		assertEquals("ROR",emp.getDept());
		
	}
	
	@Test
	public void testDelete(){		
		Employee emp1 = employeeRepository.findEmployee(5);
		Employee emp = employeeRepository.deleteEmployee(emp1);
		//System.out.println(emp.getDept());
		assertNull(emp);
		
	}
	
	
	
}
