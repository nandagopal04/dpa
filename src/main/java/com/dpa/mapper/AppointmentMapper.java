package com.dpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.dpa.config.GlobalMapperConfig;
import com.dpa.dto.AppointmentDTO;
import com.dpa.dto.AppointmentViewDTO;
import com.dpa.entity.Appointment;
import com.dpa.entity.DoctorMaster;
import com.dpa.entity.Patient;

@Mapper(config = GlobalMapperConfig.class, uses = { DoctorMaster.class, Patient.class })
public interface AppointmentMapper extends GlobalMapper<Appointment, AppointmentDTO> {

	AppointmentViewDTO mapToAppointmentView(Appointment appointment);

	List<AppointmentViewDTO> mapToAppointmentViewList(List<Appointment> appointments);

}
