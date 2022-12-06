package com.ty.HealthConsultation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ty.HealthConsultation.dto.Patient;
import com.ty.HealthConsultation.service.PatientService;
import com.ty.HealthConsultation.util.ResponseStructure;

@Controller
@RequestMapping("/patients")
public class PatientController {
	@Autowired
	PatientService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<Patient>> savePatient(@RequestBody Patient patient) {
		return service.savePatient(patient);
	}

	@PutMapping("/{patientId}")
	public ResponseEntity<ResponseStructure<Patient>> updatePatient(@RequestBody Patient patient,
			@PathVariable int patientId) {
		return service.updatePatient(patient, patientId);
	}

	@GetMapping("/{patientId}")
	public ResponseEntity<ResponseStructure<Patient>> getPatientById(@PathVariable int patientId) {
		return service.getPatientById(patientId);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<List<Patient>>> getAllPatient() {
		return service.getAllPatient();
	}

	@DeleteMapping("/{patientId}")
	public ResponseEntity<ResponseStructure<Patient>> delatepatient(@PathVariable int patientId) {
		return service.delatepatient(patientId);
	}
}
