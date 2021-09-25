package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="EmpTab")
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer Id;	
	
	@Column(name="ename")
	private String emName;
	
	@Column(name="esalay")
	private Double empSalary;
	
	@Column(name="edept")
	private String empDept;
	
	@Column(name="eaddr")
	private String empAddr;
	

	
	
}
