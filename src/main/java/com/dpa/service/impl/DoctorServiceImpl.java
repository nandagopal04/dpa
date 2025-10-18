package com.dpa.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpa.dto.DoctorMasterDTO;
import com.dpa.entity.DoctorMaster;
import com.dpa.repository.DoctorRepository;
import com.dpa.service.DoctorService;
import com.dpa.vo.DoctorAppointmentSummaryVO;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<DoctorAppointmentSummaryVO> getDoctorAppointmentSummaryWithPatientCountAndAppointmentCount() {
		return doctorRepository.getDoctorAppointmentSummaryWithPatientCountAndAppointmentCount();
	}

	@Override
	public List<DoctorMasterDTO> getDoctorsWithAboveAverageFee() {
		List<DoctorMaster> doctorMasters = doctorRepository.findDoctorsWithAboveAverageFee();
		return modelMapper.map(doctorMasters, new TypeToken<List<DoctorMasterDTO>>() {
		}.getType());
	}

	@Override
	public List<DoctorMasterDTO> getDoctorsHavingAtLeastNAppointments(Integer minCount) {
		List<DoctorMaster> doctorMasters = doctorRepository.getDoctorsHavingAtLeastNAppointments(minCount);
		return modelMapper.map(doctorMasters, new TypeToken<List<DoctorMasterDTO>>() {
		}.getType());
	}

}
