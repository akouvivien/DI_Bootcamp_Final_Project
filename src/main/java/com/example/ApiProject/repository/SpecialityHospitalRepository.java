package com.example.ApiProject.repository;

import com.example.ApiProject.model.SpecialityHospital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityHospitalRepository  extends JpaRepository<SpecialityHospital,Long> {
}
