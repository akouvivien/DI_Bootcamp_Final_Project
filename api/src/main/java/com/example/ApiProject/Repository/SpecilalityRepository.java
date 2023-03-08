package com.example.ApiProject.repository;

import com.example.ApiProject.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecilalityRepository extends JpaRepository <Speciality,Long> {
}
