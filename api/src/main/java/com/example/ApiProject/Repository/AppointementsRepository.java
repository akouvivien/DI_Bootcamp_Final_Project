package com.example.ApiProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.ApiProject.Model.Appointements;

import java.util.Date;

public interface AppointementsRepository extends JpaRepository<Appointements,Long> {

    
    @Query("SELECT a FROM Appointements a WHERE a.date=:date")
    Appointements findAllByDate(Date date);


}
