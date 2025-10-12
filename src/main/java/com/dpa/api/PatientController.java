package com.dpa.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dpa.service.PatientService;
import com.dpa.vo.PatientAppointmentSummaryVO;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping(value = "/summary/with-apt-count")
	public ResponseEntity<List<PatientAppointmentSummaryVO>> getAllPatientsWithAppointmentCount() {
		List<PatientAppointmentSummaryVO> patients = patientService.getAllPatientsWithAppointmentCount();
		return (patients == null || patients.isEmpty()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(patients, HttpStatus.OK);
	}

}
