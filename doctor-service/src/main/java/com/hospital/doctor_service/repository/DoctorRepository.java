package com.hospital.doctor_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.doctor_service.entities.Doctors;

public interface DoctorRepository extends JpaRepository<Doctors,Integer> {

}
