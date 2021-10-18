package hp.care.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="appointment_tbl")
public class Appointment {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long id;
	
	@ManyToOne
	@JoinColumn(name="app_doc_id_fk_col")
	private Doctor doctor;
	
	@DateTimeFormat(iso=ISO.DATE)
	@Temporal(TemporalType.DATE)
	@Column(name = "app_dte_col" )
	private Date date;
	
	
	@Column(name = "app_slots_col")
	private Integer noOfSlots;
	
	@Column(name="app_dtls_col")
	private String details;
	
	@Column(name="app_fee_col")
	private Double fee;
	
}
