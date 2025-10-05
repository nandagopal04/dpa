package com.dpa.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpa.dto.AppointmentDTO;
import com.dpa.entity.Appointment;
import com.dpa.repository.AppointmentRepository;
import com.dpa.service.AppointmentService;

@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<AppointmentDTO> getAppointmentsBetweenDates(LocalDate fromDate, LocalDate toDate) {
		List<Appointment> appointments = appointmentRepository.getAppointmentsBetweenDates(fromDate, toDate);
		return modelMapper.map(appointments, new TypeToken<List<AppointmentDTO>>() {
		}.getType());
	}

}
