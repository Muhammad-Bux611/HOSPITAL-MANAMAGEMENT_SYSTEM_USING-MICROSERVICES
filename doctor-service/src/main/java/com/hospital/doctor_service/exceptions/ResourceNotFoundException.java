package com.hospital.doctor_service.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public String message;

    public ResourceNotFoundException(String message){
        super(message);
    }

}
