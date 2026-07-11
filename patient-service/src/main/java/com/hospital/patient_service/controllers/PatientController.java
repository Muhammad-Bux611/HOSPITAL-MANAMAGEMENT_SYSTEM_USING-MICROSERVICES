package com.hospital.patient_service.controllers;

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

import com.hospital.patient_service.dtos.PatientDto;
import com.hospital.patient_service.services.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @PostMapping("/")
    public ResponseEntity<PatientDto> addPatient(@Valid @RequestBody PatientDto patientDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.createPatientDto(patientDto));
    }
    @GetMapping("/")
    public ResponseEntity<List<PatientDto>> allPatients(){

        return ResponseEntity.status(HttpStatus.FOUND).body(patientService.getAllPatients());
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDto> getById(@PathVariable Integer patientId){
        return ResponseEntity.status(HttpStatus.FOUND).body(patientService.getPatientDtoById(patientId));
    }

    

}
