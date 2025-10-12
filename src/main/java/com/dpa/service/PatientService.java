package com.dpa.service;

import java.util.List;

import com.dpa.vo.PatientAppointmentSummaryVO;

public interface PatientService {

	List<PatientAppointmentSummaryVO> getAllPatientsWithAppointmentCount();

}
