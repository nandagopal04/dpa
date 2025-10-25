package com.dpa.mapper;

import org.mapstruct.Mapper;

import com.dpa.config.GlobalMapperConfig;
import com.dpa.dto.AppointmentDTO;
import com.dpa.entity.Appointment;

@Mapper(config = GlobalMapperConfig.class)
public interface AppointmentMapper extends GlobalMapper<Appointment, AppointmentDTO> {
}
