package com.dpa.service;

import org.springframework.data.domain.Page;

import com.dpa.dto.DoctorMasterDTO;
import com.dpa.vo.DoctorAppointmentSummaryVO;

public interface DoctorService {

	Page<DoctorAppointmentSummaryVO> getDoctorAppointmentSummaryWithPatientCountAndAppointmentCount(Integer offset, Integer pageSize);

	Page<DoctorMasterDTO> getDoctorsWithAboveAverageFee(Integer offset, Integer pageSize);

	Page<DoctorMasterDTO> getDoctorsHavingAtLeastNAppointments(Integer minCount, Integer offset, Integer pageSize);

}
