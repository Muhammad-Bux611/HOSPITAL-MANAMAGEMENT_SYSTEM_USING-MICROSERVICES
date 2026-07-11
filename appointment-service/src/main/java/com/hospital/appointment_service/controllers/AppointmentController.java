package com.hospital.appointment_service.controllers;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.appointment_service.dtos.AppointmentRequest;
import com.hospital.appointment_service.dtos.AppointmentResponse;
import com.hospital.appointment_service.services.AppointmentServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    public final AppointmentServices appointmentServices;

    AppointmentController(AppointmentServices appointmentServices){
        this.appointmentServices=appointmentServices;
    }

    @PostMapping("/")
    public ResponseEntity<AppointmentResponse> placeAppointment(@Valid @RequestBody AppointmentRequest appointmentRequest){
        AppointmentResponse appointmentResponse = appointmentServices.createAppointment(appointmentRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentResponse);
    }


    @GetMapping("/")
    public ResponseEntity<List<AppointmentResponse>> getAllAppointments(){
        return ResponseEntity.status(HttpStatus.FOUND).body(appointmentServices.getAllAppointments());
    }
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AppointmentResponse>> getAllAppointmentsThroughDocotorId(@PathVariable Integer doctorId){
        return ResponseEntity.status(HttpStatus.FOUND).body(appointmentServices.getAppointmentsBySpecificDocotor(doctorId));
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<AppointmentResponse> updateAppointment(@PathVariable Integer appointmentId , @Valid @RequestBody AppointmentRequest appointmentRequest){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(appointmentServices.updateAppointment(appointmentId, appointmentRequest));
    }

}
