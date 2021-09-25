package hp.care.app;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Hello {

	@javax.persistence.Id
	private Integer Id;
	private String name;
	
	
	
}
