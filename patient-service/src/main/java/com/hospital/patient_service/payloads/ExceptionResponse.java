package com.hospital.patient_service.payloads;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExceptionResponse {

    private String message;
    private Integer status;

}
