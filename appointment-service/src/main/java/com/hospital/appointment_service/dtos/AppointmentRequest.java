package com.hospital.appointment_service.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class AppointmentRequest {

    @NotNull(message = "patient id is required")
    private Integer patientId;
    @NotNull(message = "patient id is required")
    private Integer doctorId;
    @NotNull(message = "appointment date is required")
    @FutureOrPresent(message = "appointment date can not be in the  past")
    private LocalDate appointmentDate;
    @NotNull(message = "appointment time is required")
    private LocalTime appointmentTime;
    @NotBlank(message = "Appointment reason is required")
    @Size(min = 25,max = 250,message = "Length of the reason should be 25-250")
    private String reason;
    

}
