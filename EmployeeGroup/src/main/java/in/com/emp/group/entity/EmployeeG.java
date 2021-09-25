package in.com.emp.group.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="emg")
public class EmployeeG {

	@Column(name="empid")
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="name")
	private String Name;
	
	@Column(name="currency")
	private Double currency;
	
}
