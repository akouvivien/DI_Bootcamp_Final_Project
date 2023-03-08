package com.example.ApiProject.Repository;

import com.example.ApiProject.Model.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

}
