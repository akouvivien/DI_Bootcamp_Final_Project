package com.example.ApiProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiProject.Model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
