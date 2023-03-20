package com.example.ApiProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ApiProject.Dto.AssignationDto;
import com.example.ApiProject.Model.Doctor;
import com.example.ApiProject.Model.Hospital;
import com.example.ApiProject.Model.HospitalDoctor;

@Service
public interface HospitalDoctorService {

    HospitalDoctor createHospitalDoctor(AssignationDto assignationDto);

    List<HospitalDoctor> getHospitalDoctors();

    Optional<HospitalDoctor> getHospitalDoctorId(Long id);

    void DeleteHospitalDoctorId(Long id);

    void deleteHospitalDoctors();

    HospitalDoctor updateHospitalDoctor(Long id, AssignationDto assignationDto);

    //recherche par doctor
    List<HospitalDoctor> getbyDoctors(Doctor doctor);

    //recherche par hopital et specialité
    // List<HospitalSpeciality> getbyall(AssignationDto assignationDto);

    //recherche par doctor
    List<HospitalDoctor> getbyHospital(Hospital hospital);
    
}
