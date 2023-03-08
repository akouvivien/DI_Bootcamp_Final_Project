package com.example.ApiProject.Controller;
import com.example.ApiProject.Dto.PatientDto;
import com.example.ApiProject.Model.Patient;
import com.example.ApiProject.Service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/patient")

public class PatientController {

    @Autowired
    PatientService patientService;

        @GetMapping("")
        public ResponseEntity<List<Patient>> getALLPatients (){

            patientService.getPatients();

            return new ResponseEntity<>(patientService.getPatients(), HttpStatus.OK);
        }

        @GetMapping("/{id}")

        public ResponseEntity<Patient> getPatientById(@PathVariable("id") Long id) {

           patientService.getPatientId(id);

            return new ResponseEntity<>(patientService.getPatientId(id).get(), HttpStatus.OK);

        }

        @PostMapping("")
        public ResponseEntity<String> createPatient(@Validated @RequestBody PatientDto patientdto) {

            patientService.createPatient(patientdto);

            return new ResponseEntity<>("Enregistrement effectué avec succès !",HttpStatus.NOT_FOUND);
        }

        @PutMapping("/{id}")
        //modification via l'id
        public ResponseEntity<Patient> updatePatient(@PathVariable("id") long id, @RequestBody PatientDto patientDto) {

            Patient newUpdatePatient = patientService.updatePatient(id, patientDto);

            return new ResponseEntity<>(newUpdatePatient, HttpStatus.OK);
        }


        @DeleteMapping("/{id}")

        public ResponseEntity<HttpStatus> deletePatient(@Validated @RequestBody  @PathVariable("id") long id) {

            patientService.deletePatientId(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }

        @DeleteMapping("")

        public ResponseEntity<HttpStatus> deleteAllPatients() {

                patientService.deletePatients();

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

}








