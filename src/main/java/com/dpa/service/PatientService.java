package com.dpa.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dpa.dto.PatientDTO;
import com.dpa.vo.PatientAppointmentSummaryVO;
import com.dpa.vo.PatientNameAndDob;

public interface PatientService {

	Page<PatientAppointmentSummaryVO> getAllPatientsWithAppointmentCount(Integer offset, Integer pageSize);

	Page<PatientDTO> getPatientsGreaterThanAge(Integer age, Integer offset, Integer pageSize);

	Page<PatientDTO> getPatientsBookedTwoDoctors(Integer offset, Integer pageSize);

	List<String> getPatientIds();

	List<PatientNameAndDob> getPatientNamesAndDobs();

	List<String> getPatientNamesHavingAppointmentsInMonth(Integer month);

}
