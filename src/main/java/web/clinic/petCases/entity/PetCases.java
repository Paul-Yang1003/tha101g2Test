package web.clinic.petCases.entity;

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
public class PetCases {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer casesSn;
	@Column
	private Integer vetSn;
	@Column
	private Integer userId;
	@Column
	private Date appointDate;
	@Column
	private String ownerMobile;
	@Column
	private String petType;
	@Column
	private String petName;
	@Column
	private Integer petGender;
	@Column
	private Integer petAge;
	@Column
	private String petSituation;
	@Column
	private String treatment;
	@Column
	private Integer result;
}
