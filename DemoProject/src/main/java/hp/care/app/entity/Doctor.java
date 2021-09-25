package hp.care.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Doctortbl")
@Data
public class Doctor {

	
	@Column(name="dname")
	private String dname;
	
	@Column(name="emailid")
	private String EmailId;
	
	@Column(name="dspecialization")
	private String dspecialization;
	
	@Column(name="daddress")
	private String daddress;
	
	@Column(name="dmobileno")
	private long dmobileno;
	
	@Column(name="dgender")
	private String dgender;
	
	@Column(name="dnote")
	private String dnote;
	
}
