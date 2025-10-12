package com.dpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpa.repository.PatientRepository;
import com.dpa.service.PatientService;
import com.dpa.vo.PatientAppointmentSummaryVO;

@Service("patientService")
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<PatientAppointmentSummaryVO> getAllPatientsWithAppointmentCount() {
		return patientRepository.getAllPatientsWithAppointmentCount();
	}

}
