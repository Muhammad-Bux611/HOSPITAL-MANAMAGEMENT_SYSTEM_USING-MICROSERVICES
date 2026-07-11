package com.hospital.appointment_service.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PatientResponse {

    private String patientName;
    private Integer patientAge;
    private String disease;
    
}
