package com.hospital.appointment_service.payloads;

import org.mapstruct.Mapper;

import com.hospital.appointment_service.dtos.AppointmentRequest;
import com.hospital.appointment_service.dtos.AppointmentResponse;
import com.hospital.appointment_service.entities.Appointment;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    Appointment toEntity(AppointmentRequest appointmentRequest);
    AppointmentRequest toDto(Appointment appointment);
    AppointmentResponse toResponse(Appointment appointment);

}
