package com.example.ApiProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ApiProject.Dto.AppointementDto;
import com.example.ApiProject.Model.Appointements;
import com.example.ApiProject.Model.Patient;
import com.example.ApiProject.Model.Hospital;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AppointementsRepository extends JpaRepository<Appointements,Long> {

// liste des rdv par date
@Query("SELECT a FROM Appointements a WHERE a.date=:date")

Appointements findAllByDate(Date date);

//recherche par rapport a patient
List<Appointements> findAllByPatient(Patient patient);

Appointements  findByHospitalAndPatient(Hospital hospital, Patient patient);

//recherche par rapport a  patient et l'hopital
// List<Appointements> findAllByPatientAndHospital(AppointementDto appointementDto);

//recherche par rapport a doctor
List<Appointements> findAllByHospital(Hospital hospital);


//TODO affiche le nombre de rdv par date et par hopital 

//TODO affiche le nombre de rdv par MOIS et par hopital 
//TODO affiche le nombre de rdv par année et par hopital 

//TODO affiche la liste des rdv par hopital

//TODO affiche le nombre de rdv en cours de traitements par hopital et par jour ou mois ou année
//TODO affiche la liste des rdv en cours de traitements par hopital et par jour ou mois ou année

//TODO affiche le nombre de rdv  Validés par hopital et par jour ou mois ou année
//TODO affiche la liste des rdv Validés par hopital et par jour ou mois ou année

//TODO affiche le nombre de rdv annulée  par hopital et par jour ou mois ou anné

//TODO affiche la liste des rdv  par  patient et  par l'hopital
//TODO affiche le nombre  de rdv par  patient et  par l'hopital


}