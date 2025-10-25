package com.dpa.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

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
public class PatientDTO {

	private String id;
	private String name;
	private LocalDate dob;
	@Enumerated(EnumType.STRING)
	private GenderType gender;
	private BigDecimal weight;
	private BigDecimal height;

}
