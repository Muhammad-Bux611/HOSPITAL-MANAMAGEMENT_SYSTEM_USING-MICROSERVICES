package com.hospital.patient_service.services;

import java.util.List;

import com.hospital.patient_service.dtos.PatientDto;

public interface PatientService {

    public PatientDto createPatientDto(PatientDto patientDto);
    public PatientDto getPatientDtoById(Integer patientId);
    public List<PatientDto> getAllPatients();
    public PatientDto updatePatientDto(Integer patientId, PatientDto patientDto);
    public boolean deletePatientById(Integer patientId);

}
