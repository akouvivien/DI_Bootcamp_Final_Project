package com.example.ApiProject.model;

import lombok.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.sql.Time;
import java.time.Month;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Appointements implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
    private Long id;
   
    private Date date;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    
  
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
