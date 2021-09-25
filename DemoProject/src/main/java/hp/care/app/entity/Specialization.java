package hp.care.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="specialization")
@Data
public class Specialization {

	@Id
	@Column(name="sid")
	private Integer id;
	
	@Column(name="scode")
	private long code;
	
	@Column(name="sname")
	private String sname;
	
	@Column(name="snote")
	private String snote;
}
