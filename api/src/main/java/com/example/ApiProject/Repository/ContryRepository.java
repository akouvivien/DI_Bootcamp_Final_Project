package com.example.ApiProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiProject.Model.Contry;

@Repository
public interface ContryRepository extends JpaRepository<Contry,Long> {
}
