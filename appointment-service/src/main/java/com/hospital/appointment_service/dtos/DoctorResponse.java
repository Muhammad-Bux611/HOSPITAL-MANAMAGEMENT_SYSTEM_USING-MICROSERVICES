package com.hospital.appointment_service.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DoctorResponse {

    private String doctorName;
    private String department;
    private String  specialization;

}
