package com.dpa.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dpa.dto.AppointmentDTO;
import com.dpa.dto.AppointmentViewDTO;
import com.dpa.dto.DoctorPatientDTO;
import com.dpa.entity.Appointment;
import com.dpa.mapper.AppointmentMapper;
import com.dpa.repository.AppointmentRepository;
import com.dpa.service.AppointmentService;
import com.dpa.vo.AppointmentSummaryVO;

@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	private AppointmentMapper appointmentMapper;

	@Autowired
	public void setAppointmentMapper(AppointmentMapper appointmentMapper) {
		this.appointmentMapper = appointmentMapper;
	}

	@Override
	public Page<AppointmentDTO> getAppointmentsBetweenDates(LocalDate fromDate, LocalDate toDate, Integer offset,
			Integer pageSize) {
		Page<Appointment> appointments = appointmentRepository.getAppointmentsBetweenDates(fromDate, toDate,
				PageRequest.of(offset, pageSize));
		return appointmentMapper.mapToDTOPage(appointments);
	}

	@Override
	public Page<AppointmentSummaryVO> getAllAppointmentsWithDoctorNames(Integer offset, Integer pageSize) {
		return appointmentRepository.getAllWithDoctorNames(PageRequest.of(offset, pageSize));
	}

	@Override
	public List<AppointmentViewDTO> getAllAppointmentViews() {
		List<Appointment> appointments = appointmentRepository.findAll();
		return appointmentMapper.mapToAppointmentViewList(appointments);
	}

	@Override
	public List<DoctorPatientDTO> getDoctorsWithPatients() {
		List<Appointment> appointments = appointmentRepository.findAll();
		return appointmentMapper.mapToDoctorPatientDTOList(appointments);
	}

}
