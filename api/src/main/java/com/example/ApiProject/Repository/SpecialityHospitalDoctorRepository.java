package com.example.ApiProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiProject.Model.SpecialityHospitalDoctor;

@Repository
public interface SpecialityHospitalDoctorRepository  extends JpaRepository<SpecialityHospitalDoctor,Long> {

//TODO affiche la liste des specialitées par hopital
//TODO affiche le nombre  de specialitées par hopital


//TODO affiche la liste des Medcins par hopital
//TODO affiche la liste des Medcins par specialité


//TODO affiche la liste des Medcins par specialité et par hopital
//TODO affiche le nombre  de  Medcins specialité et par hopital
 
}
