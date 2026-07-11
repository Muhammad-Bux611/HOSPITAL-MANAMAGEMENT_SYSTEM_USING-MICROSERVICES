package com.hospital.doctor_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.doctor_service.dtos.DoctorDto;
import com.hospital.doctor_service.services.DoctorServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorServices doctorServices;

    @PostMapping("/")
    public ResponseEntity<DoctorDto> addDoctor(@Valid @RequestBody DoctorDto doctorDto){
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(doctorServices.createDoctorDto(doctorDto));
    }
    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Integer doctorId){
        return ResponseEntity.status(HttpStatus.FOUND).body(doctorServices.getDoctorById(doctorId));
    }

    @GetMapping("/")
    public ResponseEntity<List<DoctorDto>> getAllDoctors(){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(doctorServices.getAllDoctor());
    }

}
