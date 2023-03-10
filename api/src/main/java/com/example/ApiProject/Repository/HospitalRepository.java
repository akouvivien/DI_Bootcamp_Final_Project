package com.example.ApiProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ApiProject.Dto.CityDto;
import com.example.ApiProject.Dto.ContryDto;
import com.example.ApiProject.Dto.MunicipalityDto;
import com.example.ApiProject.Model.City;
import com.example.ApiProject.Model.Contry;
import com.example.ApiProject.Model.Hospital;
import com.example.ApiProject.Model.Municipality;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long> {

//TODO savoir si prendre en compte les objets ou les string pour les requetes et savoir commen

    //list des hopitaux disponibles par pays ville, communes, municipalité et disponibilité de l'hopital ( a ajouter )

    // @Query( "SELECT h FROM hospital h WHERE h JOIN h.municipality m JOIN m.city c JOIN c.contry co WHERE"+
    //  "co =: Contry AND c =: City AND m =: Municipality AND h.status=:status")
     
    // List<Hospital> findHospitalByCritary(@Param("contry") Contry contry, @Param("City") City city,@Param("Municipality") Municipality municipality,@Param("Status") String Status );

    // List<Hospital> findHospitalByCritary(ContryDto contrydto, CityDto citydto, MunicipalityDto municipalitydto, String status);
}
