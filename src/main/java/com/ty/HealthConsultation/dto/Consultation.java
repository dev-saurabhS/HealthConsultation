package com.ty.HealthConsultation.dto;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;


import lombok.Data;

@Entity
@Data
public class Consultation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	private int consultationId;
	@CreationTimestamp
	private LocalDate doc;
	@NotEmpty
	private String causeDetails;
	@NotEmpty
	private String prescription;
	private double cost;
}
