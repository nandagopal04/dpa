package com.dpa.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dpa.service.DoctorService;
import com.dpa.vo.DoctorAppointmentSummaryVO;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@GetMapping("/summary/with-patient-and-apt-count")
	public ResponseEntity<List<DoctorAppointmentSummaryVO>> getDoctorAppointmentSummaryWithPatientAndAppointmentCount() {
		List<DoctorAppointmentSummaryVO> summary = doctorService
				.getDoctorAppointmentSummaryWithPatientCountAndAppointmentCount();
		return (summary == null || summary.isEmpty()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: ResponseEntity.ok(summary);
	}

}
