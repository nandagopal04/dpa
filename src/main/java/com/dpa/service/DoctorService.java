package com.dpa.service;

import java.util.List;

import com.dpa.dto.DoctorMasterDTO;
import com.dpa.vo.DoctorAppointmentSummaryVO;

public interface DoctorService {

	List<DoctorAppointmentSummaryVO> getDoctorAppointmentSummaryWithPatientCountAndAppointmentCount();

	List<DoctorMasterDTO> getDoctorsWithAboveAverageFee();

}
