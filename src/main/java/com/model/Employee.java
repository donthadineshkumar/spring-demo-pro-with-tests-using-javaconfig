package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="Employee")
public class Employee {
	
	
	public Employee() {
	}
	
	public Employee(Integer empno, String name, String dept, Double salary) {
		this.empno = empno;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer empno;
	
	@Size(min=1, max=30)
	@NotEmpty
	private String name;
	
	@NotEmpty
	@Size(min=1, max=30)
	private String dept;

	/*@NotEmpty - cannot be set to double - supports String Collection Map arrays*/
	private Double salary;
	
	
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	

}
