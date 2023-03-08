package com.example.ApiProject.Service;


import com.example.ApiProject.Dto.PatientDto;
import com.example.ApiProject.Model.Patient;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PatientService {


    Patient createPatient(PatientDto patientDto);

    Patient updatePatient(Long id, PatientDto patientDto);

    void deletePatientId(Long id);

    Optional<Patient> getPatientId(Long id);


    List<Patient> getPatients();

    void deletePatients();

}