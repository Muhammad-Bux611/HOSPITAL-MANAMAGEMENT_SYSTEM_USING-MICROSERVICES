package com.hospital.appointment_service.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.hospital.appointment_service.dtos.AppointmentRequest;
import com.hospital.appointment_service.dtos.AppointmentResponse;
import com.hospital.appointment_service.dtos.DoctorResponse;
import com.hospital.appointment_service.dtos.PatientResponse;
import com.hospital.appointment_service.entities.Appointment;
import com.hospital.appointment_service.exceptions.ResourceNotFoundException;
import com.hospital.appointment_service.payloads.AppointmentMapper;
import com.hospital.appointment_service.repositories.AppointmentRepository;
import com.hospital.appointment_service.services.AppointmentServices;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentServices {

    public final RestClient restClient;
    public final AppointmentRepository appointmentRepository;
    public final AppointmentMapper appointmentMapper;

    @Override
    public AppointmentResponse createAppointment(AppointmentRequest appointmentRequest) {
        PatientResponse patientResponse = getPatient(appointmentRequest.getPatientId());
        DoctorResponse doctorResponse = getDoctor(appointmentRequest.getDoctorId());
        Appointment appointment = appointmentMapper.toEntity(appointmentRequest);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        
        AppointmentResponse response = new AppointmentResponse();
        response.setAppointmentDate(savedAppointment.getAppointmentDate());
        response.setAppointmentId(savedAppointment.getAppointmentId());
        response.setAppointmentTime(savedAppointment.getAppointmentTime());
        response.setDoctorResponse(doctorResponse);
        response.setPatientResponse(patientResponse);
        return response;
    }


    public PatientResponse getPatient(Integer patientId){

        
        ResponseEntity<PatientResponse> patientResponse = restClient.get()
        .uri("http://localhost:8080/api/patients/{patientId}",patientId)
        .retrieve()
        .onStatus(HttpStatusCode::is4xxClientError,(request,response)->{
            throw new ResourceNotFoundException("Patient with ID "+patientId+ " not found");
        })
        .toEntity(PatientResponse.class);

        return patientResponse.getBody();

    }

    public DoctorResponse getDoctor(Integer doctorId){

        
        ResponseEntity<DoctorResponse> doctor = restClient.get()
        .uri("http://localhost:8081/api/doctors/{doctorId}",doctorId)
        .retrieve()
        .onStatus(HttpStatusCode::is4xxClientError,(request,response)->{
            throw new ResourceNotFoundException("Doctor with ID "+doctorId+ "not found");
        })
        .toEntity(DoctorResponse.class);

        return doctor.getBody();

    }


    @Override
    public List<AppointmentResponse> getAllAppointments() {
       List<Appointment> appointments = appointmentRepository.findAll();
       if (appointments.isEmpty()) {
        throw new ResourceNotFoundException("There is no any appointment is stored in the database");
       }

       List<AppointmentResponse> appointmentResponses = appointments.stream().map(appointment -> {
        PatientResponse patientResponse = getPatient(appointment.getPatientId());
        DoctorResponse doctorResponse = getDoctor(appointment.getDoctorId());
        AppointmentResponse appointmentResponse = appointmentMapper.toResponse(appointment);
        appointmentResponse.setDoctorResponse(doctorResponse);
        appointmentResponse.setPatientResponse(patientResponse);
        return appointmentResponse;
       }).toList();

       return appointmentResponses;
    }


    @Override
    public AppointmentResponse getAppointmentById(Integer appointmentId) {
       Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(()->new ResourceNotFoundException("Appointment with id :"+ appointmentId+" is not found"));
        PatientResponse patientResponse = getPatient(appointment.getPatientId());
        DoctorResponse doctorResponse = getDoctor(appointment.getDoctorId());
       AppointmentResponse appointmentResponse = appointmentMapper.toResponse(appointment);
       appointmentResponse.setDoctorResponse(doctorResponse);
       appointmentResponse.setPatientResponse(patientResponse);
       return appointmentResponse;
    }


    @Override
    public List<AppointmentResponse> getAppointmentsBySpecificDocotor(Integer doctorId) {
        DoctorResponse doctorResponse = getDoctor(doctorId);
        List<Appointment> appointments = appointmentRepository.findAllByDoctorId(doctorId);

       return appointments.stream().map(appointment->{
        PatientResponse patientResponse = getPatient(appointment.getPatientId()); 
        AppointmentResponse appointmentResponse = appointmentMapper.toResponse(appointment);
        appointmentResponse.setDoctorResponse(doctorResponse);
        appointmentResponse.setPatientResponse(patientResponse);
            return appointmentResponse;
        }).toList();
    }


    @Override
    public AppointmentResponse updateAppointment(Integer appointmentId, AppointmentRequest appointmentRequest) {
        
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(()->new ResourceNotFoundException("Appointment with id "+appointmentId+ " is not found"));
        appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());
        appointment.setAppointmentTime(appointmentRequest.getAppointmentTime());
        appointment.setDoctorId(appointmentRequest.getDoctorId());
        appointment.setPatientId(appointmentRequest.getPatientId());
        appointment.setReason(appointmentRequest.getReason());

        Appointment updatedAppointment = appointmentRepository.save(appointment);
        PatientResponse patientResponse = getPatient(updatedAppointment.getPatientId());
        DoctorResponse  doctorResponse = getDoctor(appointment.getDoctorId());

        AppointmentResponse appointmentResponse = appointmentMapper.toResponse(updatedAppointment);
        appointmentResponse.setDoctorResponse(doctorResponse);
        appointmentResponse.setPatientResponse(patientResponse);
        return appointmentResponse;
    }

}
