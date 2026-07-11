package com.hospital.appointment_service.services;

import java.util.List;

import com.hospital.appointment_service.dtos.AppointmentRequest;
import com.hospital.appointment_service.dtos.AppointmentResponse;

public interface AppointmentServices {

    public AppointmentResponse createAppointment(AppointmentRequest appointmentRequest);
    public List<AppointmentResponse> getAllAppointments();
    public AppointmentResponse getAppointmentById(Integer appointmentId);
    public List<AppointmentResponse> getAppointmentsBySpecificDocotor(Integer doctorId);
    public AppointmentResponse updateAppointment(Integer appointmentId, AppointmentRequest appointmentRequest);

}
