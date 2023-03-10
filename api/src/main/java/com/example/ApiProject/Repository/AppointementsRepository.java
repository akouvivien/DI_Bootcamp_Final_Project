package com.example.ApiProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.ApiProject.Model.Appointements;

import java.util.Date;

public interface AppointementsRepository extends JpaRepository<Appointements,Long> {

    // liste des rdv par date
    @Query("SELECT a FROM Appointements a WHERE a.date=:date")
    Appointements findAllByDate(Date date);

//TODO affiche le nombre de rdv par date et par hopital 
//TODO affiche le nombre de rdv par MOIS et par hopital 
//TODO affiche le nombre de rdv par année et par hopital 

//TODO affiche la liste des rdv par hopital

//TODO affiche le nombre de rdv en cours de traitements par hopital et par jour ou mois ou année
//TODO affiche la liste des rdv en cours de traitements par hopital et par jour ou mois ou année

//TODO affiche le nombre de rdv  Validés par hopital et par jour ou mois ou année
//TODO affiche la liste des rdv Validés par hopital et par jour ou mois ou année

//TODO affiche le nombre de rdv annulée  par hopital et par jour ou mois ou année
//TODO affiche la liste des rdv annulée  par hopital et par jour ou mois ou année>>

//TODO affiche la liste des rdv  par  patient et  par l'hopital
//TODO affiche le nombre  de rdv par  patient et  par l'hopital

}
