package com.example.ApiProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiProject.Model.Speciality;

@Repository
public interface SpecilalityRepository extends JpaRepository <Speciality,Long> {
}
