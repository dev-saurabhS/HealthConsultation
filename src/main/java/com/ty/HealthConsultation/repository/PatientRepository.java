package com.ty.HealthConsultation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.HealthConsultation.dto.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
