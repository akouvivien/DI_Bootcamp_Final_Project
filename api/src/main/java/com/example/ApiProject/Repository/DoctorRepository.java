package com.example.ApiProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiProject.Model.Doctor;
import com.example.ApiProject.Model.Speciality;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

     List<Doctor> findAllBySpeciality(Speciality speciality);

}
