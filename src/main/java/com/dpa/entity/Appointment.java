package com.dpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = { "id" })
public class Appointment implements Serializable {

	private static final long serialVersionUID = -70035221070730282L;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String doctorId;
	private String patientId;
	private LocalDateTime bookedOn;

	@OneToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "doctorId", referencedColumnName = "id", insertable = false, updatable = false)
	private DoctorMaster doctorMaster;
	@OneToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "patientId", referencedColumnName = "id", insertable = false, updatable = false)
	private Patient patient;

}
