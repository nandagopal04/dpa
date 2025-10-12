package com.dpa.vo;

import java.math.BigDecimal;

import com.dpa.constant.GenderType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class DoctorAppointmentSummaryVO {
	
	private String doctorId;
	private String doctorName;
	@Enumerated(EnumType.STRING)
	private GenderType gender;
	private String speciality;
	private BigDecimal fee;
	private Long totalAppointments;
	private Long totalPatitens;

}
