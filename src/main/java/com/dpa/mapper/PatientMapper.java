package com.dpa.mapper;

import org.mapstruct.Mapper;

import com.dpa.config.GlobalMapperConfig;
import com.dpa.dto.PatientDTO;
import com.dpa.entity.Patient;

@Mapper(config = GlobalMapperConfig.class)
public interface PatientMapper extends GlobalMapper<Patient, PatientDTO>{

}
