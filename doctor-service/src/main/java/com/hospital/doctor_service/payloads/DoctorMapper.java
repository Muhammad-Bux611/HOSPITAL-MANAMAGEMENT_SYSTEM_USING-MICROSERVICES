package com.hospital.doctor_service.payloads;

import org.mapstruct.Mapper;

import com.hospital.doctor_service.dtos.DoctorDto;
import com.hospital.doctor_service.entities.Doctors;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

  public  Doctors toEntity(DoctorDto doctorDto);
  public  DoctorDto toDto(Doctors doctors);

}
