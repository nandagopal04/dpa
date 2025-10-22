package com.dpa.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dpa.dto.AppointmentDTO;
import com.dpa.dto.AppointmentViewDTO;
import com.dpa.service.AppointmentService;
import com.dpa.vo.AppointmentSummaryVO;

@RestController()
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping(value = "/by/dates")
	public ResponseEntity<Page<AppointmentDTO>> getAppointmentsBetweenDates(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam(required = false, defaultValue = "0") Integer offset,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {
		Page<AppointmentDTO> appointmentDTOs = appointmentService.getAppointmentsBetweenDates(LocalDate.parse(fromDate),
				LocalDate.parse(toDate), offset, pageSize);
		return (appointmentDTOs == null || appointmentDTOs.isEmpty()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Page<AppointmentDTO>>(appointmentDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/summary/with/doctor-names")
	public ResponseEntity<Page<AppointmentSummaryVO>> getAllAppointmentsWithDoctorNames(
			@RequestParam(required = false, defaultValue = "0") Integer offset,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {
		Page<AppointmentSummaryVO> appointmentSummaryVOs = appointmentService.getAllAppointmentsWithDoctorNames(offset,
				pageSize);
		return (appointmentSummaryVOs == null || appointmentSummaryVOs.isEmpty())
				? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Page<AppointmentSummaryVO>>(appointmentSummaryVOs, HttpStatus.OK);
	}

	@GetMapping(value = "/view")
	public ResponseEntity<List<AppointmentViewDTO>> getAllAppointmentViews() {
		List<AppointmentViewDTO> appointmentViews = appointmentService.getAllAppointmentViews();
		return (appointmentViews == null || appointmentViews.isEmpty()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(appointmentViews, HttpStatus.OK);
	}

}
