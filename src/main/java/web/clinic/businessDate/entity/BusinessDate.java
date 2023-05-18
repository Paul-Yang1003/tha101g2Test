package web.clinic.businessDate.entity;

import java.sql.Date;

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
public class BusinessDate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer businessSn;
	@Column
	private Integer clinicId;
	@Column
    private Integer vetSn;
	@Column
    private Integer weekDate;
	@Column
    private Integer morningBusiness;
	@Column
    private Integer morningAppoIntegerMax;
	@Column
    private Integer afternoonBusiness;
	@Column
    private Integer afternoonAppoIntegerMax;
	@Column
    private Integer nightBusiness;
	@Column
    private Integer nightAppoIntegerMax;
}
