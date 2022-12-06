package com.ty.HealthConsultation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.ty.HealthConsultation.dao.PatientDao;
import com.ty.HealthConsultation.dto.Patient;
import com.ty.HealthConsultation.exception.IdNotFoundException;
import com.ty.HealthConsultation.repository.PatientRepository;
import com.ty.HealthConsultation.util.ResponseStructure;

@Controller
public class PatientService {
	@Autowired
	PatientDao dao;
	@Autowired
	PatientRepository repository;

	public ResponseEntity<ResponseStructure<Patient>> savePatient(Patient patient) {
		ResponseStructure<Patient> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("SUCCESS");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(dao.savePatient(patient));
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Patient>> updatePatient(Patient patient, int patientId) {
		ResponseStructure<Patient> responseStructure = new ResponseStructure<>();
		Optional<Patient> optional = repository.findById(patientId);
		if (optional.isPresent()) {
			Patient patientObj = optional.get();
			responseStructure.setMessage("SUCCESS");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dao.savePatient(patientObj));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Patient>> getPatientById(int patientId) {
		ResponseStructure<Patient> responseStructure = new ResponseStructure<>();
		Optional<Patient> optional = repository.findById(patientId);
		if (optional.isPresent()) {
			responseStructure.setMessage("SUCCESS");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(optional.get());
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Patient>>> getAllPatient() {
		ResponseStructure<List<Patient>> responseStructure = new ResponseStructure<List<Patient>>();
		responseStructure.setMessage("SUCCESS");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(repository.findAll());
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Patient>> delatepatient(int patientId) {
		ResponseStructure<Patient> responseStructure = new ResponseStructure<>();
		Optional<Patient> optional = repository.findById(patientId);
		if (optional.isPresent()) {
			dao.deletePatient(patientId);
			responseStructure.setMessage("SUCCESS");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(null);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

}
