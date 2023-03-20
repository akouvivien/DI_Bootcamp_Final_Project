package com.example.ApiProject.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.ApiProject.Model.Hospital;
import com.example.ApiProject.Model.HospitalSpeciality;
import com.example.ApiProject.Model.Speciality;
import com.example.ApiProject.Service.HospitalSpecialityService;


@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hospitalspeciality")
public class HospitalSpecialityController {

    @Autowired
    HospitalSpecialityService hospitalSpre;

    @GetMapping("")
    public ResponseEntity<List<HospitalSpeciality>> findAll() {
        try {
            List<HospitalSpeciality> list = hospitalSpre.getHospitalSpeciality() ;
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalSpeciality> find(@PathVariable Long id) {
        try {
            Optional<HospitalSpeciality> hospitalpecialityId =  hospitalSpre.getHospitalSpecialityId(id);
            return new ResponseEntity<>(hospitalpecialityId.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<HospitalSpeciality> create(@Validated @RequestBody HospitalSpeciality hospitalspeciality) {
        try {
             hospitalSpre.createHospitalSpeciality(hospitalspeciality);
            return new ResponseEntity<>(hospitalSpre.createHospitalSpeciality(hospitalspeciality), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HospitalSpeciality> update(@PathVariable("id") Long id, @RequestBody HospitalSpeciality hospitalspeciality) {
        try {
            HospitalSpeciality newUpdateHospitalSpeciality = hospitalSpre.updateHospitalSpeciality(id, hospitalspeciality);
            return new ResponseEntity<>(newUpdateHospitalSpeciality, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            hospitalSpre.DeleteHospitalSpecialityId(id); ;
            return new ResponseEntity<>("delete succes", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        
        

        @PostMapping("/getbyspeciality")
        public ResponseEntity<List<HospitalSpeciality> > getbyspecialities(@RequestBody Speciality speciality) {
            try {
                hospitalSpre.getbyspecialities(speciality);
                return new ResponseEntity<>(hospitalSpre.getbyspecialities(speciality), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

            @PostMapping("/getbyhospitals")
            public ResponseEntity<List<HospitalSpeciality>> getbyHospitals(@RequestBody Hospital hospital) {
                try {
                    hospitalSpre.getbyHospitals(hospital); 
                    return new ResponseEntity<>(hospitalSpre.getbyHospitals(hospital), HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }

    }
}
