package com.example.ApiProject.Controller;
import com.example.ApiProject.Dto.DoctorDto;
import com.example.ApiProject.Service.DoctorService;

import com.example.ApiProject.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Validated
@RestController
@RequestMapping("/doctor")

public class DoctorController {

    @Autowired
    DoctorService doctorService;
    @GetMapping("")
    //liste des doctors
    public ResponseEntity<List<Doctor>> getALLDoctors(){

        List<Doctor> cities = doctorService.getDoctors();

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")

//affichage selon l'id
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") long id) {

        Optional<Doctor> DoctodId =  doctorService.getDoctorId(id);

        return new ResponseEntity<>(DoctodId.get(), HttpStatus.OK);
    }


    @PostMapping("")
    //enregistrement des données
    public ResponseEntity<String> createDoctor(@Validated @RequestBody DoctorDto doctorDto) {

        doctorService.CreateDoctor(doctorDto);

        return new ResponseEntity<>("Enregistrement effectué avec succès !",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    //modification via l'id
    public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") long id, @RequestBody DoctorDto doctorDto)
    {
        Doctor newUpdateCity = doctorService.UpdateDoctorId(id, doctorDto);

        return new ResponseEntity<>(newUpdateCity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    //suppression en fonction de l'id
    public ResponseEntity<HttpStatus> deleteDoctorId(@Validated @RequestBody  @PathVariable("id") long id) {

        doctorService.deleteDoctorId(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("")
    //suppression de l'ensemble des données
    public ResponseEntity<HttpStatus> deleteAllCity() {

        doctorService.deleteDoctors();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
