package web.clinic.clinicMember.entity;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClinicMember {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer clinicId;
	@Column
	private String clinicName;
	@Column
	private String clinicPrincipal;
	@Column
	private String clinicEmail;
	@Column
	private String clinicPassword;
	@Column
	private String clinicPhone;
	@Column
	private Timestamp clinicMemberDate;
	@Column
	private String clinicAddress;
	@Column
	private Blob clinicPhoto;
	@Column
	private String clinicService;
	
}
