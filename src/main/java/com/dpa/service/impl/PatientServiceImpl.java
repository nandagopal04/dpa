package com.dpa.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Page<PatientAppointmentSummaryVO> getAllPatientsWithAppointmentCount(Integer offset, Integer pageSize) {
		return patientRepository.getAllPatientsWithAppointmentCount(PageRequest.of(offset, pageSize));
	}

	@Override
	public Page<PatientDTO> getPatientsGreaterThanAge(Integer age, Integer offset, Integer pageSize) {
		Page<Patient> patients = patientRepository.getPatientsGreaterThanAge(age, PageRequest.of(offset, pageSize));
		return modelMapper.map(patients, new TypeToken<Page<PatientDTO>>() {
		}.getType());
	}

	@Override
	public Page<PatientDTO> getPatientsBookedTwoDoctors(Integer offset, Integer pageSize) {
		Page<Patient> patients = patientRepository.getPatientsBookedTwoDoctors(PageRequest.of(offset, pageSize));
		return modelMapper.map(patients, new TypeToken<Page<PatientDTO>>() {
		}.getType());
	}

}
