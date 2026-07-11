package com.hospital.patient_service.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hospital.patient_service.dtos.PatientDto;
import com.hospital.patient_service.enitities.Patients;
import com.hospital.patient_service.exceptions.ResourceNotFoundException;
import com.hospital.patient_service.payloads.PatientMapper;
import com.hospital.patient_service.repositories.PatientRepository;
import com.hospital.patient_service.services.PatientService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {


    public final PatientMapper patientMapper;
    public final PatientRepository patientRepository;


    @Override
    public PatientDto createPatientDto(PatientDto patientDto) {
      Patients patients = patientMapper.toEntity(patientDto);
     Patients savedPatients= patientRepository.save(patients);
     return patientMapper.toDto(savedPatients);
    }

    @Override
    public PatientDto getPatientDtoById(Integer patientId) {
   Patients patients=   patientRepository.findById(patientId).orElseThrow(
        ()-> new ResourceNotFoundException("Patient not found with id "+patientId)
      );

      return patientMapper.toDto(patients);
    }

    @Override
    public List<PatientDto> getAllPatients() {
    List<Patients> patients =  patientRepository.findAll();
    if (patients==null) {
        throw new ResourceNotFoundException("There is no any patients is registered in the database yet");
    }else{
      List<PatientDto> patientDtos=  patients.stream().map(patient->patientMapper.toDto(patient)).toList();

      return patientDtos;
    }
    }

    @Override
    public PatientDto updatePatientDto(Integer patientId, PatientDto patientDto) {
        return null;
    }

    @Override
    public boolean deletePatientById(Integer patientId) {

        return false;
      
    }

}
