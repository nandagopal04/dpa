package com.dpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dpa.dto.PatientDTO;
import com.dpa.entity.Patient;
import com.dpa.mapper.PatientMapper;
import com.dpa.repository.PatientRepository;
import com.dpa.service.PatientService;
import com.dpa.vo.PatientAppointmentSummaryVO;
import com.dpa.vo.PatientNameAndDob;

@Service("patientService")
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	private PatientMapper patientMapper;

	@Autowired
	public void setPatientMapper(PatientMapper patientMapper) {
		this.patientMapper = patientMapper;
	}

	@Override
	public Page<PatientAppointmentSummaryVO> getAllPatientsWithAppointmentCount(Integer offset, Integer pageSize) {
		return patientRepository.getAllPatientsWithAppointmentCount(PageRequest.of(offset, pageSize));
	}

	@Override
	public Page<PatientDTO> getPatientsGreaterThanAge(Integer age, Integer offset, Integer pageSize) {
		Page<Patient> patients = patientRepository.getPatientsGreaterThanAge(age, PageRequest.of(offset, pageSize));
		return patientMapper.mapToDTOPage(patients);
	}

	@Override
	public Page<PatientDTO> getPatientsBookedTwoDoctors(Integer offset, Integer pageSize) {
		Page<Patient> patients = patientRepository.getPatientsBookedTwoDoctors(PageRequest.of(offset, pageSize));
		return patientMapper.mapToDTOPage(patients);
	}

	@Override
	public List<String> getPatientIds() {
		return patientRepository.getAllPatientIds();
	}

	@Override
	public List<PatientNameAndDob> getPatientNamesAndDobs() {
		return patientRepository.getPatientNamesAndDobs();
	}

	@Override
	public List<String> getPatientNamesHavingAppointmentsInMonth(Integer month) {
		return patientRepository.getPatientNamesHavingAppointmentsInMonth(month);
	}

}
