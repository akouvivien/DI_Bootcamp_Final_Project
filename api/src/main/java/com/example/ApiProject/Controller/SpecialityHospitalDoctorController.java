package com.example.ApiProject.Controller;

import com.example.ApiProject.Dto.SpecialityHospitalDoctorDto;
import com.example.ApiProject.Model.SpecialityHospitalDoctor;
import com.example.ApiProject.Service.SpecialityHospitalDoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/specialityhospitaldoctor")
public class SpecialityHospitalDoctorController {

        @Autowired
        SpecialityHospitalDoctorService specialityHospitalService;

        @GetMapping("")
        public ResponseEntity<List<SpecialityHospitalDoctor>> getALLSpecialityHospitalDoctor(){

            List<SpecialityHospitalDoctor> list = specialityHospitalService.getSpecialityHospitals() ;

            return new ResponseEntity<>(list, HttpStatus.OK);

        }

        @GetMapping("/{id}")

        public ResponseEntity<SpecialityHospitalDoctor> getSpecialityHospitalDoctorById(@PathVariable("id") Long id) {

            Optional<SpecialityHospitalDoctor> specialityHospitalDoctorId =  specialityHospitalService.getSpecialityHospitalId(id);

            return new ResponseEntity<>(specialityHospitalDoctorId.get(), HttpStatus.OK);
        }

        @PostMapping("")
        public ResponseEntity<String> createSpecialityHospitalDoctor(@Validated @RequestBody SpecialityHospitalDoctorDto specialityHospitalDoctorDto) {

            specialityHospitalService.createSpecialityHospital(specialityHospitalDoctorDto);

            return new ResponseEntity<>("Enregistrement effectué avec succès !",HttpStatus.NOT_FOUND);
        }

        @PutMapping("/{id}")
        //modification via l'id
        public ResponseEntity<SpecialityHospitalDoctor> updateSpecialityHospitalDoctor(@PathVariable("id") Long id, @RequestBody SpecialityHospitalDoctorDto specialityHospitalDoctorDto) {

            SpecialityHospitalDoctor newUpdateSpecialityHospital = specialityHospitalService.updateSpecialityHospital(id, specialityHospitalDoctorDto);

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

