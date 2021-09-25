package hp.hosp.group.special.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
@Entity
public class Doctor {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer did;
	
	@Column(name="name")
	private String dname;
	
	@Column(name="emailId")
	private String EmailId;
	
	@Column(name="specialization")
	private String specialization;
	
	@Column(name="daddress")
	private String Address;
	
	@Column(name="mobile")
	private Integer dmobile;
	
	@Column(name="gender")
	private String dGender;
	
	@Column(name="note")
	private String dnote;
	
	
	
}
