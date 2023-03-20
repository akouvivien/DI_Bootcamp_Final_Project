package com.example.ApiProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiProject.Model.Doctor;
import com.example.ApiProject.Model.Hospital;
import com.example.ApiProject.Model.HospitalDoctor;

@Repository
public interface HospitalDoctorRepository extends JpaRepository<HospitalDoctor, Long> {

//recherche par rapport hopital
List<HospitalDoctor> findAllByHospital(Hospital hospital);

//recherche par rapport a  patient et l'hopital
// List<HospitalDoctor> findAllByHospitalAndDoctor(AssignationDto assignationDto);

//recherche par rapport a doctor
List<HospitalDoctor> findAllByDoctor(Doctor doctor);


}
