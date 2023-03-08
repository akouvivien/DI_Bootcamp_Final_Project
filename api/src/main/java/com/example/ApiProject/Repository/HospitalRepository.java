package com.example.ApiProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiProject.Model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long> {
}
