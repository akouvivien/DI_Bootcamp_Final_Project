package com.example.ApiProject.repository;

import com.example.ApiProject.Dto.PatientDto;
import com.example.ApiProject.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

}
