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

	private String id;
	private LocalDateTime bookedOn;
	private DoctorMasterDTO doctorMaster;
	private PatientDTO patient;

}
