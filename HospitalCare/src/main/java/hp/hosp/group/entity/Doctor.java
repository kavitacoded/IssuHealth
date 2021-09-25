package hp.hosp.group.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Doctor")
public class Doctor {
	
	@Id
	private Integer Id;
//	private String Name;
//	private String Emailid;
//	private String Specialization;
//	private String Address;
//	private Integer Mobileno;
//	private String Gender;
//	private String Note;
//	
	
}
