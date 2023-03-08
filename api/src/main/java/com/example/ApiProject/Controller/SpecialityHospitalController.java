package com.example.ApiProject.Controller;

import com.example.ApiProject.Dto.SpecialityHospitalDto;
import com.example.ApiProject.Model.SpecialityHospital;
import com.example.ApiProject.Service.SpecialityHospitalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/specialityHospitalDoctor")
public class SpecialityHospitalController {

        @Autowired
        SpecialityHospitalService specialityHospitalService;

        @GetMapping("")
        public ResponseEntity<List<SpecialityHospital>> getALLSpecialityHospitalDoctor(){

            List<SpecialityHospital> list = specialityHospitalService.getSpecialityHospitals() ;

            return new ResponseEntity<>(list, HttpStatus.OK);

        }

        @GetMapping("/{id}")

        public ResponseEntity<SpecialityHospital> getSpecialityHospitalDoctorById(@PathVariable("id") Long id) {

            Optional<SpecialityHospital> specialityHospitalDoctorId =  specialityHospitalService.getSpecialityHospitalId(id);

            return new ResponseEntity<>(specialityHospitalDoctorId.get(), HttpStatus.OK);
        }

        @PostMapping("")
        public ResponseEntity<String> createSpecialityHospitalDoctor(@Validated @RequestBody SpecialityHospitalDto specialityHospitalDto) {

            specialityHospitalService.createSpecialityHospital(specialityHospitalDto);

            return new ResponseEntity<>("Enregistrement effectué avec succès !",HttpStatus.NOT_FOUND);
        }

        @PutMapping("/{id}")
        //modification via l'id
        public ResponseEntity<SpecialityHospital> updateSpecialityHospitalDoctor(@PathVariable("id") Long id, @RequestBody SpecialityHospitalDto specialityHospitalDto) {

            SpecialityHospital newUpdateSpecialityHospital = specialityHospitalService.updateSpecialityHospital(id, specialityHospitalDto);

            return new ResponseEntity<>(newUpdateSpecialityHospital, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")

        public ResponseEntity<String> deleteSpecialityHospitalDoctors(@Validated @RequestBody  @PathVariable("id") Long id) {

            specialityHospitalService.deleteSpecialityHospitalId(id);

            return new ResponseEntity<>("Suppression effectuer  avec succes !",HttpStatus.NO_CONTENT);
        }

        @DeleteMapping("")

        public ResponseEntity<String> deleteAllAppointements() {

            specialityHospitalService.deleteSpecialityHospitals();

            return new ResponseEntity<>("L'ensemble des données a éte effacer avec succes !",HttpStatus.NO_CONTENT);

        }
    }

