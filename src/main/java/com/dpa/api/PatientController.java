package com.dpa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dpa.dto.PatientDTO;
import com.dpa.service.PatientService;
import com.dpa.vo.PatientAppointmentSummaryVO;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping(value = "/summary/with-apt-count")
	public ResponseEntity<Page<PatientAppointmentSummaryVO>> getAllPatientsWithAppointmentCount(
			@RequestParam(required = false, defaultValue = "0") Integer offset,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {
		Page<PatientAppointmentSummaryVO> patients = patientService.getAllPatientsWithAppointmentCount(offset,
				pageSize);
		return (patients == null || patients.isEmpty()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(patients, HttpStatus.OK);
	}

	@GetMapping(value = "/age/greater-than")
	public ResponseEntity<Page<PatientDTO>> getPatientsGreaterThanAge(@RequestParam Integer age,
			@RequestParam(required = false, defaultValue = "0") Integer offset,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {
		Page<PatientDTO> patients = patientService.getPatientsGreaterThanAge(age, offset, pageSize);
		return (patients == null || patients.isEmpty()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(patients, HttpStatus.OK);
	}

	@GetMapping(value = "/booked-two-doctors")
	public ResponseEntity<Page<PatientDTO>> getPatientsBookedTwoDoctors(
			@RequestParam(required = false, defaultValue = "0") Integer offset,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {
		Page<PatientDTO> patients = patientService.getPatientsBookedTwoDoctors(offset, pageSize);
		return (patients == null || patients.isEmpty()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(patients, HttpStatus.OK);
	}

}
