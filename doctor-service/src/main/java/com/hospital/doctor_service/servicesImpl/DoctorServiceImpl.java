package com.hospital.doctor_service.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hospital.doctor_service.dtos.DoctorDto;
import com.hospital.doctor_service.entities.Doctors;
import com.hospital.doctor_service.exceptions.ResourceNotFoundException;
import com.hospital.doctor_service.payloads.DoctorMapper;
import com.hospital.doctor_service.repository.DoctorRepository;
import com.hospital.doctor_service.services.DoctorServices;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorServices{

    public final DoctorMapper doctorMapper;
    public final DoctorRepository doctorRepository;

    @Override
    public DoctorDto createDoctorDto(DoctorDto doctorDto) {
        Doctors doctor = doctorMapper.toEntity(doctorDto);
        Doctors savedDoctor = doctorRepository.save(doctor);
        return doctorMapper.toDto(savedDoctor);
    }

    @Override
    public DoctorDto getDoctorById(Integer doctorId) {
        Doctors doctor = doctorRepository.findById(doctorId).orElseThrow(
            ()->new ResourceNotFoundException("Doctor not found with id "+doctorId)
        );
        return doctorMapper.toDto(doctor);
    }

    @Override
    public List<DoctorDto> getAllDoctor() {
        List<Doctors> doctors = doctorRepository.findAll();
        if (doctors!=null) {
            throw new ResourceNotFoundException("Not any doctor is registered yet");
        }
        List<DoctorDto> doctorDtos = doctors.stream().map(doctor->doctorMapper.toDto(doctor)).toList();
        return doctorDtos;
        
    }

    @Override
    public DoctorDto updateDoctorDto(Integer doctorId, DoctorDto doctorDto) {
       return null;
    }

    @Override
    public boolean deleteDoctor(Integer doctorId) {
        return false;
    }

}
