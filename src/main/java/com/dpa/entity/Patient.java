package com.dpa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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
public class Patient implements Serializable {

	private static final long serialVersionUID = 1278880233737472277L;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String name;
	private LocalDate dob;
	@Enumerated(EnumType.STRING)
	private GenderType geneder;
	private BigDecimal weight;
	private BigDecimal height;

}
