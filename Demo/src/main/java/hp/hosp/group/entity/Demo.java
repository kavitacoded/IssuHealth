package hp.hosp.group.entity;

import javax.persistence.Column;

import lombok.Data;

@Data
public class Demo {

	@Column
	@javax.persistence.Id
	private Integer Id;
}
