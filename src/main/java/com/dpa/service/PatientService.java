package com.dpa.service;

import org.springframework.data.domain.Page;

import com.dpa.dto.PatientDTO;
import com.dpa.vo.PatientAppointmentSummaryVO;

public interface PatientService {

	Page<PatientAppointmentSummaryVO> getAllPatientsWithAppointmentCount(Integer offset, Integer pageSize);

	Page<PatientDTO> getPatientsGreaterThanAge(Integer age, Integer offset, Integer pageSize);

	Page<PatientDTO> getPatientsBookedTwoDoctors(Integer offset, Integer pageSize);

}
