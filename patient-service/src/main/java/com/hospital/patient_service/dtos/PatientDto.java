package com.hospital.patient_service.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PatientDto {

    @NotBlank(message = "patient name is required")
    @Size(min = 3, message = "patient name should be greater or equal to 3 letters")
    private String patientName;
    @NotNull(message = "patient age is requied and that is greater then 0")
    @Positive(message = "age should be greater than 0")
    private Integer patientAge;
    @NotBlank(message = "Disease is requied")
    @Size(min = 3,message = "disease name should be greater or equals to 3 characters")
    private String disease;

}
