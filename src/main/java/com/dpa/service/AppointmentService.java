package com.dpa.service;

import java.time.LocalDate;
import java.util.List;

import com.dpa.dto.AppointmentDTO;
import com.dpa.vo.AppointmentSummaryVO;

public interface AppointmentService {

	List<AppointmentDTO> getAppointmentsBetweenDates(LocalDate fromDate, LocalDate toDate);

	List<AppointmentSummaryVO> getAllAppointmentsWithDoctorNames();

}
