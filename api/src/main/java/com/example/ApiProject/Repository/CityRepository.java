package com.example.ApiProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiProject.Model.City;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
}
