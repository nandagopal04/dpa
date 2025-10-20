package com.dpa.service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import com.dpa.dto.AppointmentDTO;
import com.dpa.vo.AppointmentSummaryVO;

public interface AppointmentService {

	Page<AppointmentDTO> getAppointmentsBetweenDates(LocalDate fromDate, LocalDate toDate, Integer offset, Integer pageSize);

	Page<AppointmentSummaryVO> getAllAppointmentsWithDoctorNames(Integer offset, Integer pageSize);

}
