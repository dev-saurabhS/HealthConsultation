package com.ty.HealthConsultation.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.HealthConsultation.dto.Consultation;
import com.ty.HealthConsultation.repository.ConsultationRepository;


@Repository
public class ConsultationDao {

	@Autowired
	private ConsultationRepository consultationRepository ;

	public Consultation saveConsultation(Consultation consultation ) {
		return consultationRepository.save(consultation);
	}

	public Optional<Consultation> getConsultation(int id) {
		return consultationRepository.findById(id);
	}

	public Consultation deleteConsultation(Consultation consultation) {
		consultationRepository.delete(consultation);
	 return consultation;
	}
	public Optional<Consultation> updateConsultation(int id, Consultation consultation) {
		return consultationRepository.findById(id);
	}
	
	public List<Consultation> getAllConsultation(){
		return consultationRepository.findAll();
	}
}
