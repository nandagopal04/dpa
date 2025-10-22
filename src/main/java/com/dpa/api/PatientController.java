package com.dpa.api;

import java.util.List;

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
import com.dpa.vo.PatientNameAndDob;

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

	@GetMapping(value = "/ids")
	public ResponseEntity<List<String>> getPatientIds() {
		List<String> patientIds = patientService.getPatientIds();
		return (patientIds == null || patientIds.isEmpty()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(patientIds, HttpStatus.OK);
	}

	@GetMapping(value = "/names-and-dobs")
	public ResponseEntity<List<PatientNameAndDob>> getPatientNamesAndDobs() {
		List<PatientNameAndDob> patientNamesAndDobs = patientService.getPatientNamesAndDobs();
		return (patientNamesAndDobs == null || patientNamesAndDobs.isEmpty())
				? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(patientNamesAndDobs, HttpStatus.OK);
	}

	@GetMapping(value = "/names/having-appointments/by-month")
	public ResponseEntity<List<String>> getPatientNamesHavingAppointmentsInMonth(
			@RequestParam Integer month) {
		List<String> patientNamesAndDobs = patientService.getPatientNamesHavingAppointmentsInMonth(month);
		return (patientNamesAndDobs == null || patientNamesAndDobs.isEmpty())
				? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(patientNamesAndDobs, HttpStatus.OK);
	}

}
