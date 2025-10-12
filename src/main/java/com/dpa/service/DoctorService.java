package com.dpa.service;

import java.util.List;

import com.dpa.vo.DoctorAppointmentSummaryVO;

public interface DoctorService {

	List<DoctorAppointmentSummaryVO> getDoctorAppointmentSummaryWithPatientCountAndAppointmentCount();

}
