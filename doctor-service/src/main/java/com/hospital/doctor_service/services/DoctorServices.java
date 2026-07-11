package com.hospital.doctor_service.services;

import java.util.List;

import com.hospital.doctor_service.dtos.DoctorDto;

public interface DoctorServices {

    public DoctorDto createDoctorDto(DoctorDto doctorDto);
    public DoctorDto getDoctorById(Integer doctorId);
    public List<DoctorDto> getAllDoctor();
    public DoctorDto updateDoctorDto(Integer doctorId, DoctorDto doctorDto);
    public boolean deleteDoctor(Integer doctorId);

}
