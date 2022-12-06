package com.ty.HealthConsultation.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.HealthConsultation.dao.ConsultationDao;
import com.ty.HealthConsultation.dto.Consultation;
import com.ty.HealthConsultation.exception.IdNotFoundException;
import com.ty.HealthConsultation.util.ResponseStructure;

@Service
public class ConsultationService {

	@Autowired
	private ConsultationDao consultationDao;
	
	public ResponseEntity<ResponseStructure<Consultation>> saveConsultation(Consultation consultation) {
		ResponseStructure<Consultation> responseStructure = new ResponseStructure<Consultation>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("CREATED");
		responseStructure.setData(consultationDao.saveConsultation(consultation));
		return new ResponseEntity<ResponseStructure<Consultation>>(responseStructure, HttpStatus.CREATED);
	
	}

	public ResponseEntity<ResponseStructure<Consultation>> getConsultationById(int id) {
		ResponseStructure<Consultation> responseStructure = new ResponseStructure<Consultation>();
		Optional<Consultation> optional = consultationDao.getConsultation(id);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("OK");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<Consultation>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Consultation>> deleteConsultation(int id) {
		ResponseStructure<Consultation> responseStructure = new ResponseStructure<Consultation>();
		Optional<Consultation> optional = consultationDao.getConsultation(id);
		if (optional.isPresent()) {
			Consultation consultation = optional.get();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("OK");
			responseStructure.setData(consultationDao.deleteConsultation(consultation));
			return new ResponseEntity<ResponseStructure<Consultation>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Consultation>> updateConsultation(int id, Consultation consultation) {
		ResponseStructure<Consultation> responseStructure = new ResponseStructure<Consultation>();
		Optional<Consultation> optional = consultationDao.getConsultation(id);
		if (optional.isPresent()) {
			Consultation consultation1 = optional.get();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("OK");
			responseStructure.setData(consultationDao.saveConsultation(consultation1));
			return new ResponseEntity<ResponseStructure<Consultation>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Consultation>>> getAllConsultation() {
		ResponseStructure<List<Consultation>> responseStructure = new ResponseStructure<List<Consultation>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("OK");
		responseStructure.setData(consultationDao.getAllConsultation());
		return new ResponseEntity<ResponseStructure<List<Consultation>>>(responseStructure, HttpStatus.OK);
	}
}
