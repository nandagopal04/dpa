package com.dpa.mapper;

import org.mapstruct.Mapper;

import com.dpa.config.GlobalMapperConfig;
import com.dpa.dto.DoctorMasterDTO;
import com.dpa.entity.DoctorMaster;

@Mapper(config = GlobalMapperConfig.class)
public interface DoctorMapper extends GlobalMapper<DoctorMaster, DoctorMasterDTO> {
}
