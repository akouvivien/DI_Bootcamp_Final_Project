package com.example.ApiProject.repository;

import com.example.ApiProject.model.Appointements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AppointementsRepository extends JpaRepository<Appointements,Long> {

    
    @Query("SELECT a FROM Appointements a WHERE a.date=:date")
    Appointements findAllByDate(Date date);


}
