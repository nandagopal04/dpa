package com.dpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpa.repository.DoctorRepository;
import com.dpa.service.DoctorService;
import com.dpa.vo.DoctorAppointmentSummaryVO;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public List<DoctorAppointmentSummaryVO> getDoctorAppointmentSummaryWithPatientCountAndAppointmentCount() {
		return doctorRepository.getDoctorAppointmentSummaryWithPatientCountAndAppointmentCount();
	}

}
