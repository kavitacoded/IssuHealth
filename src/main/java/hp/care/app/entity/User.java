package hp.care.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name="user_tab")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="usr_id_col")
	private Long id;
	
	@Column(name="usr_display_name_col")
	private String dispalyName;
	
	@Column(name="usr_uname_col")
	private String username;
	
	@Column(name="usr_pwd_col")
	private String password;

	@Column(name="usr_urole_role")
	private String role;
	
}
