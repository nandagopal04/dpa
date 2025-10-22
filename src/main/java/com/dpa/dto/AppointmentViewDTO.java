package com.dpa.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
public class AppointmentViewDTO {

	private String appointmentId;
	private LocalDateTime bookedOn;
	private DoctorNameDTO doctor;
	private PatientNameDTO patient;

	public AppointmentViewDTO(String appointmentId, LocalDateTime bookedOn, String doctorId, String doctorName,
			String patientId, String patientName) {
		this.appointmentId = appointmentId;
		this.bookedOn = bookedOn;
		this.doctor = new DoctorNameDTO(doctorId, doctorName);
		this.patient = new PatientNameDTO(patientId, patientName);
	}

}
