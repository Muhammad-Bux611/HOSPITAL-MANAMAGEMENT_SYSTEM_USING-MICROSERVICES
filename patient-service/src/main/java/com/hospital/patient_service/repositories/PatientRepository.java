package com.hospital.patient_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.patient_service.enitities.Patients;
@Repository
public interface PatientRepository extends JpaRepository<Patients, Integer> {

}
