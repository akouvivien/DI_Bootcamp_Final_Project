package com.example.ApiProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiProject.Model.Municipality;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality,Long> {
}
