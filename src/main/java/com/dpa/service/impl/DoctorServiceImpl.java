package com.dpa.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dpa.dto.DoctorMasterDTO;
import com.dpa.entity.DoctorMaster;
import com.dpa.repository.DoctorRepository;
import com.dpa.service.DoctorService;
import com.dpa.vo.DoctorAppointmentSummaryVO;
import com.dpa.vo.DoctorFee;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Page<DoctorAppointmentSummaryVO> getDoctorAppointmentSummaryWithPatientCountAndAppointmentCount(
			Integer offset, Integer pageSize) {
		return doctorRepository
				.getDoctorAppointmentSummaryWithPatientCountAndAppointmentCount(PageRequest.of(offset, pageSize));
	}

	@Override
	public Page<DoctorMasterDTO> getDoctorsWithAboveAverageFee(Integer offset, Integer pageSize) {
		Page<DoctorMaster> doctorMasters = doctorRepository
				.findDoctorsWithAboveAverageFee(PageRequest.of(offset, pageSize));
		List<DoctorMasterDTO> doctorMasterDTOs = modelMapper.map(doctorMasters.getContent(),
				new TypeToken<List<DoctorMasterDTO>>() {
				}.getType());
		return new PageImpl<DoctorMasterDTO>(doctorMasterDTOs, doctorMasters.getPageable(),
				doctorMasters.getTotalElements());
	}

	@Override
	public Page<DoctorMasterDTO> getDoctorsHavingAtLeastNAppointments(Integer minCount, Integer offset,
			Integer pageSize) {
		Page<DoctorMaster> doctorMasters = doctorRepository.getDoctorsHavingAtLeastNAppointments(minCount,
				PageRequest.of(offset, pageSize));
		return modelMapper.map(doctorMasters, new TypeToken<Page<DoctorMasterDTO>>() {
		}.getType());
	}

	@Override
	public List<DoctorMasterDTO> getDoctorsHavingAppointmentsBetweenDates(LocalDate fromDate, LocalDate toDate) {
		List<DoctorMaster> doctorMasters = doctorRepository.getDoctorsHavingAppointmentsBetweenDates(fromDate, toDate);
		return modelMapper.map(doctorMasters, new TypeToken<List<DoctorMasterDTO>>() {
		}.getType());
	}

	@Override
	public List<DoctorFee> getAllDoctorsAndFees() {
		return doctorRepository.getAllDoctorsAndFees();
	}

}
