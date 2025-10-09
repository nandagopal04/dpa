package com.dpa.vo;

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
public class AppointmentSummaryVO {

	private String id;
	private String doctorId;
	private String patientId;
	private LocalDateTime bookedOn;
	private String doctorName;
	private String patientName;

	public AppointmentSummaryVO(String id, String doctorId, String patientId, LocalDateTime bookedOn,
			String doctorName) {
		this.id = id;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.bookedOn = bookedOn;
		this.doctorName = doctorName;
	}

}
