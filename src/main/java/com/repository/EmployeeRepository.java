package com.repository;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Transactional
	public Employee findEmployee(int id){
		return (Employee)sessionFactory.getCurrentSession().get(Employee.class, id);
	}
	
	
	@Transactional
	public Employee saveEmployee(Employee emp){
		Serializable id= sessionFactory.getCurrentSession().save(emp);
		return new Employee((Integer)id,emp.getName(),emp.getDept(), emp.getSalary());
	}
	
	
	@Transactional
	public Employee updateEmployee(Employee emp){
		sessionFactory.getCurrentSession().saveOrUpdate(emp);	
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, emp.getEmpno());
	}
	
	@Transactional
	public Employee deleteEmployee(Employee emp){
		sessionFactory.getCurrentSession().delete(emp);	
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, emp.getEmpno());
	}
	
	
}
