package com.dpa.service;

import java.util.List;

import com.dpa.dto.PatientDTO;
import com.dpa.vo.PatientAppointmentSummaryVO;

public interface PatientService {

	List<PatientAppointmentSummaryVO> getAllPatientsWithAppointmentCount();

	List<PatientDTO> getPatientsGreaterThanAge(Integer age);

	List<PatientDTO> getPatientsBookedTwoDoctors();

}
