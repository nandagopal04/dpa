package com.dpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

}
