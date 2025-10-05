package com.dpa.dto;

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
@EqualsAndHashCode(of = { "id" })
public class DoctorMasterDTO {

	private String id;
	private String name;
	@Enumerated(EnumType.STRING)
	private GenderType gender;
	private String speciality;
	private BigDecimal fee;

}
