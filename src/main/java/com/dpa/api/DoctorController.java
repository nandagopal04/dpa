package com.dpa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dpa.dto.DoctorMasterDTO;
import com.dpa.service.DoctorService;
import com.dpa.vo.DoctorAppointmentSummaryVO;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@GetMapping("/summary/with-patient-and-apt-count")
	public ResponseEntity<Page<DoctorAppointmentSummaryVO>> getDoctorAppointmentSummaryWithPatientAndAppointmentCount(
			@RequestParam(required = false, defaultValue = "0") Integer offset,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {
		Page<DoctorAppointmentSummaryVO> summary = doctorService
				.getDoctorAppointmentSummaryWithPatientCountAndAppointmentCount(offset, pageSize);
		return (summary == null || summary.isEmpty()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: ResponseEntity.ok(summary);
	}

	// Fetch doctors with fee greater than average fee
	@GetMapping(value = "/above-avg-fee")
	public ResponseEntity<Page<DoctorMasterDTO>> getDoctorsWithAboveAverageFee(
			@RequestParam(required = false, defaultValue = "0") Integer offset,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {
		Page<DoctorMasterDTO> doctors = doctorService.getDoctorsWithAboveAverageFee(offset, pageSize);
		return (doctors == null || doctors.isEmpty()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: ResponseEntity.ok(doctors);
	}

	@GetMapping(value = "/having-min-appointments")
	public ResponseEntity<Page<DoctorMasterDTO>> getDoctorsHavingAtLeastNAppointments(@RequestParam Integer minCount,
			@RequestParam(required = false, defaultValue = "0") Integer offset,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {
		Page<DoctorMasterDTO> doctors = doctorService.getDoctorsHavingAtLeastNAppointments(minCount, offset, pageSize);
		return (doctors == null || doctors.isEmpty()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: ResponseEntity.ok(doctors);
	}

}
