package hp.hosp.group;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

public class Doctor {

	@Id
	@GeneratedValue
	private Integer Id;
	
	private String name;
	
	private String emailid;
	
	private String specialization;
	private String address;
	private long mobile;
	private String gender;
	private String note;
	
}
