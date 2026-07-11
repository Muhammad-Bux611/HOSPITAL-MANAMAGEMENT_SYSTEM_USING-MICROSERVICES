package com.hospital.appointment_service.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppointmentResponse {
    private Integer appointmentId;
    private PatientResponse patientResponse;
    private DoctorResponse doctorResponse;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
}
