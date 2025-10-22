package com.dpa.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;

import com.dpa.dto.DoctorMasterDTO;
import com.dpa.vo.DoctorAppointmentSummaryVO;
import com.dpa.vo.DoctorFee;

public interface DoctorService {

	Page<DoctorAppointmentSummaryVO> getDoctorAppointmentSummaryWithPatientCountAndAppointmentCount(Integer offset,
			Integer pageSize);

	Page<DoctorMasterDTO> getDoctorsWithAboveAverageFee(Integer offset, Integer pageSize);

	Page<DoctorMasterDTO> getDoctorsHavingAtLeastNAppointments(Integer minCount, Integer offset, Integer pageSize);

	List<DoctorMasterDTO> getDoctorsHavingAppointmentsBetweenDates(LocalDate fromDate, LocalDate toDate);

	List<DoctorFee> getAllDoctorsAndFees();

}
