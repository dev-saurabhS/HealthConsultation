package com.ty.HealthConsultation.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.HealthConsultation.dto.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation,Integer>{

}
