package com.dpa.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dpa.dto.AppointmentDTO;
import com.dpa.service.AppointmentService;

@RestController()
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping(value = "/by/dates")
	public ResponseEntity<List<AppointmentDTO>> getAppointmentsBetweenDates(@RequestParam String fromDate,
			@RequestParam String toDate) {
		List<AppointmentDTO> appointmentDTOs = appointmentService.getAppointmentsBetweenDates(LocalDate.parse(fromDate),
				LocalDate.parse(toDate));
		return new ResponseEntity<List<AppointmentDTO>>(appointmentDTOs, HttpStatus.OK);
	}

}
