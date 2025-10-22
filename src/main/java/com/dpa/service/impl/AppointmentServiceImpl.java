package com.dpa.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dpa.dto.AppointmentDTO;
import com.dpa.dto.AppointmentViewDTO;
import com.dpa.entity.Appointment;
import com.dpa.repository.AppointmentRepository;
import com.dpa.service.AppointmentService;
import com.dpa.vo.AppointmentSummaryVO;

@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Page<AppointmentDTO> getAppointmentsBetweenDates(LocalDate fromDate, LocalDate toDate, Integer offset, Integer pageSize) {
		Page<Appointment> appointments = appointmentRepository.getAppointmentsBetweenDates(fromDate, toDate, PageRequest.of(offset, pageSize));
		return modelMapper.map(appointments, new TypeToken<Page<AppointmentDTO>>() {
		}.getType());
	}

	@Override
	public Page<AppointmentSummaryVO> getAllAppointmentsWithDoctorNames(Integer offset, Integer pageSize) {
		return appointmentRepository.getAllWithDoctorNames(PageRequest.of(offset, pageSize));
	}

	@Override
	public List<AppointmentViewDTO> getAllAppointmentViews() {
		return appointmentRepository.getAllAppointmentViews();
	}

}
