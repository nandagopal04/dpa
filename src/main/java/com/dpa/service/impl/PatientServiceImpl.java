package com.dpa.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpa.dto.PatientDTO;
import com.dpa.entity.Patient;
import com.dpa.repository.PatientRepository;
import com.dpa.service.PatientService;
import com.dpa.vo.PatientAppointmentSummaryVO;

@Service("patientService")
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<PatientAppointmentSummaryVO> getAllPatientsWithAppointmentCount() {
		return patientRepository.getAllPatientsWithAppointmentCount();
	}

	@Override
	public List<PatientDTO> getPatientsGreaterThanAge(Integer age) {
		List<Patient> patients = patientRepository.getPatientsGreaterThanAge(age);
		return modelMapper.map(patients, new TypeToken<List<PatientDTO>>() {
		}.getType());
	}

}
