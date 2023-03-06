package com.example.ApiProject.repository;

import com.example.ApiProject.model.Contry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContryRepository extends JpaRepository<Contry,Long> {
}
