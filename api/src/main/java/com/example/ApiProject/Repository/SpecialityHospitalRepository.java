package com.example.ApiProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiProject.Model.SpecialityHospital;

@Repository
public interface SpecialityHospitalRepository  extends JpaRepository<SpecialityHospital,Long> {
}
