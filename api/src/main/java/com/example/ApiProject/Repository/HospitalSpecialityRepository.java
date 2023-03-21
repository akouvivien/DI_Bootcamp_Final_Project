package com.example.ApiProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiProject.Dto.AssignationDto;
import com.example.ApiProject.Model.Hospital;
import com.example.ApiProject.Model.HospitalSpeciality;
import com.example.ApiProject.Model.Speciality;

@Repository
public interface HospitalSpecialityRepository extends JpaRepository<HospitalSpeciality, Long> {

//recherche par rapport speciality
List<HospitalSpeciality> findAllBySpeciality(Speciality speciality);

//recherche par rapport a  patient et l'hopital
// List<HospitalSpeciality> findAllByHospitalAndSpeciality(AssignationDto assignationDto);

//recherche par rapport hopital
List<HospitalSpeciality> findAllByHospital(Hospital hospital);

HospitalSpeciality  findByHospitalAndSpeciality(Hospital hospital, Speciality speciality);

}
