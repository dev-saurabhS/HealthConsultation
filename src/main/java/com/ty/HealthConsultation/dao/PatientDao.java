package com.ty.HealthConsultation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.HealthConsultation.dto.Patient;
import com.ty.HealthConsultation.repository.PatientRepository;

@Repository
public class PatientDao {
	@Autowired
PatientRepository repository;
	
	public Patient savePatient(Patient patient) {
		Patient patientObj = repository.save(patient);
		return patientObj;
	}
	
	public Optional<Patient> updatePatient(Patient patient, int patientId) {
		return repository.findById(patientId);
	}
	
	public Optional<Patient> getPatientById(int patientId) {
		return repository.findById(patientId);
	}
	
	public List<Patient> getAllPatient(){
		return repository.findAll();
	}
	
	public Optional<Patient> deletePatient(int patientId) {
		repository.deleteById(patientId);
		return null;
	}
}
