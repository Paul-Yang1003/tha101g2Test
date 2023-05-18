package web.clinic.clinicAppointment.entity;

import java.sql.Blob;
import java.sql.Date;
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
public class ClinicAppointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer reservationNumber;
	@Column
	private Integer cardId;
	@Column
	private Integer clinicId;
	@Column
	private String vetName;
	@Column
	private Date appointDate;
	@Column
	private Integer appointTime;
	@Column
	private String ownerMobile;
	@Column
	private String petType;
	@Column
	private String petName;
	@Column
	private Integer serviceItem;
	@Column
	private Integer userId;
	@Column
	private String petSituation;
}
