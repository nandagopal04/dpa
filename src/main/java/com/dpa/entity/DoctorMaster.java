package com.dpa.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dpa.constant.GenderType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class DoctorMaster implements Serializable {

	private static final long serialVersionUID = 7592539039058537402L;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String name;
	@Enumerated(EnumType.STRING)
	private GenderType gender;
	private String speciality;
	private BigDecimal fee;

}
