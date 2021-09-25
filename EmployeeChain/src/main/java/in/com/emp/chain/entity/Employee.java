package in.com.emp.chain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Emptab")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name="empid")
	private Integer id;

	@Column(name="empname")
	private String empName;
	
	@Column(name="empsal")
	private Double empSal;
	
	@Column(name="empdept")
	private String empDept;
	
	@Column(name="empaddr")
	private String empAddr;
}
