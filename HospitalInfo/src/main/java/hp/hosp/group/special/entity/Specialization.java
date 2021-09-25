package hp.hosp.group.special.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="specilization")
public class Specialization {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer sid;
	
	@Column(name="code")
	private Integer scode;
	
	@Column(name="name")
	private String sname;
	
	@Column(name="note")
	private String snote;
	
	
	
}
