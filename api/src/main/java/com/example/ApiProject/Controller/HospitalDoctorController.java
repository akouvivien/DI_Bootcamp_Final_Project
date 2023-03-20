package com.example.ApiProject.Controller;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.ApiProject.Dto.AssignationDto;
import com.example.ApiProject.Model.Doctor;
import com.example.ApiProject.Model.Hospital;
import com.example.ApiProject.Model.HospitalDoctor;
import com.example.ApiProject.Service.HospitalDoctorService;


@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hospitaldoctor")
public class HospitalDoctorController {

    @Autowired
    HospitalDoctorService hospitalDoctorService;

    @GetMapping("")
    public ResponseEntity<List<HospitalDoctor>> findAll() {

        try {
            List<HospitalDoctor> hospitaldoctor = hospitalDoctorService.getHospitalDoctors() ;
            return new ResponseEntity<>(hospitaldoctor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalDoctor> find(@PathVariable Long id) {
        try {
            Optional<HospitalDoctor> HospitalDoctorId =  hospitalDoctorService.getHospitalDoctorId(id);
            return new ResponseEntity<>(HospitalDoctorId.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<HospitalDoctor> create(@Validated @RequestBody AssignationDto assignationDto) {
        try {
            hospitalDoctorService.createHospitalDoctor(assignationDto);
            return new ResponseEntity<>(hospitalDoctorService.createHospitalDoctor(assignationDto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("")
    public ResponseEntity<HospitalDoctor> update(@PathVariable("id") Long id, @RequestBody AssignationDto assignationDto) {
        try {
            HospitalDoctor newUpdateHospitalDoctor = hospitalDoctorService.updateHospitalDoctor(id, assignationDto);
            return new ResponseEntity<>(newUpdateHospitalDoctor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            hospitalDoctorService.DeleteHospitalDoctorId(id);
            return new ResponseEntity<>("Destroy Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getbydoctor")
    public ResponseEntity< List<HospitalDoctor>> searchbyDoctor(@Validated @RequestBody Doctor doctor) {
        try {
            hospitalDoctorService.getbyDoctors(doctor);
            return new ResponseEntity<>(hospitalDoctorService.getbyDoctors(doctor), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/getbyhospital")
    public ResponseEntity< List<HospitalDoctor>> searchbyHospital(@Validated @RequestBody Hospital hospital) {
        try {
            hospitalDoctorService.getbyHospital(hospital);
            return new ResponseEntity<>(hospitalDoctorService.getbyHospital(hospital), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
