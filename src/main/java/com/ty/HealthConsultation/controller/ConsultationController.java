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

import com.ty.HealthConsultation.dto.Consultation;
import com.ty.HealthConsultation.service.ConsultationService;
import com.ty.HealthConsultation.util.ResponseStructure;

@Controller
@RequestMapping("/consultations")
public class ConsultationController {

	@Autowired
	private ConsultationService consultationService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Consultation>> saveConsultation(@RequestBody Consultation consultation) {
		return consultationService.saveConsultation(consultation);
	}

	@PutMapping("/{patientId}")
	public ResponseEntity<ResponseStructure<Consultation>> updateConsultation(@RequestBody Consultation consultation,
			@PathVariable int consultationId) {
		return consultationService.updateConsultation(consultationId, consultation);
	}

	@GetMapping("/{patientId}")
	public ResponseEntity<ResponseStructure<Consultation>> getConsultationById(@PathVariable int patientId) {
		return consultationService.getConsultationById(patientId);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<List<Consultation>>> getAllConsultation() {
		return consultationService.getAllConsultation();
	}

	@DeleteMapping("/{patientId}")
	public ResponseEntity<ResponseStructure<Consultation>> deleteConsultation(@PathVariable int patientId) {
		return consultationService.deleteConsultation(patientId);
		
	}
}
