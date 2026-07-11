package com.hospital.doctor_service.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDto {

    @NotBlank(message = "Doctor name is required")    
    @Size(min = 3, message = "Doctor name should contain 3 or more than 3 character")
    private String doctorName;
    @NotBlank(message = "Email is required")
    @Email(message = "please enter the valid email")
    private String email;
    @NotBlank(message = "Department is required")
    @Size(min = 3,message = "Department name should contain 3 or more characters")
    private String department;
    @NotBlank(message = "Specialization is required")
    @Size(min = 3,message = "Specialization field contain less or not than 3 character")
    private String  specialization;

}
