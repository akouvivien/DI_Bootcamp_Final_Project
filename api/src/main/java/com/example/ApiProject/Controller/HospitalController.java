package com.example.ApiProject.Controller;


import com.example.ApiProject.Dto.HospitalDto;
import com.example.ApiProject.Model.Hospital;
import com.example.ApiProject.Service.HospitalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hospital")

public class HospitalController {

    @Autowired
    HospitalService hospitalService;

    @GetMapping("")
    public ResponseEntity<List<Hospital>> getALLHospital(){

        List<Hospital> hospitals = hospitalService.getHospitals();

        return new ResponseEntity<>(hospitals, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable("id") long id) {

        Optional<Hospital> hospitaltid = hospitalService.getHospitalId(id);

        return new ResponseEntity<>(hospitaltid.get(), HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity<Hospital> createHospital(@Validated @RequestBody HospitalDto hospitalDto) {

            Hospital hospitals = hospitalService.CreateHospital(hospitalDto);

            return new ResponseEntity<>(hospitals, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")

    //modification via l'id

    public ResponseEntity<Hospital> updateHospital(@PathVariable("id") Long id, @RequestBody HospitalDto hospitalDto)
     {
         Hospital newUpdateupdateHospital = hospitalService.UpdateHospitalId(id, hospitalDto);

         return new ResponseEntity<>(newUpdateupdateHospital, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")

    //suppression en fonction de l'id

    public ResponseEntity<HttpStatus> deleteHospital(@Validated @RequestBody  @PathVariable("id") Long id) {

            hospitalService.deleteHospitalId(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("")

    //suppression de l'ensemble des données

    public ResponseEntity<HttpStatus> deleteAllPatients() {

            hospitalService.deleteHospitals();

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }

}


