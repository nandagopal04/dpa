package com.dpa.service;

import java.time.LocalDate;
import java.util.List;

import com.dpa.dto.AppointmentDTO;

public interface AppointmentService {

	List<AppointmentDTO> getAppointmentsBetweenDates(LocalDate fromDate, LocalDate toDate);

}
