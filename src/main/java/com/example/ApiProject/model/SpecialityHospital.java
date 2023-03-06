package com.example.ApiProject.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "service_hospital")
public class SpecialityHospital implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    @ManyToOne()
    @JoinColumn(name = " hospital_id")
    private Hospital hospital;

    @ManyToOne()
    @JoinColumn(name = " speciality_id")
    private Speciality speciality;




}
