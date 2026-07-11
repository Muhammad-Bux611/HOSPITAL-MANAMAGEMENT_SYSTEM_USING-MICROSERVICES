package com.hospital.patient_service.payloads;

import org.mapstruct.Mapper;

import com.hospital.patient_service.dtos.PatientDto;
import com.hospital.patient_service.enitities.Patients;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patients toEntity(PatientDto PatientDto);
    PatientDto toDto(Patients patients);    
}
