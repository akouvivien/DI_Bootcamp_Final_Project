package com.example.ApiProject.Controller;

import com.example.ApiProject.Dto.SpecialityDto;
import com.example.ApiProject.Service.SpecialityService;
import com.example.ApiProject.model.Speciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Validated
@RestController
@RequestMapping("/speciality")

public class SpecialityController {

    @Autowired
    SpecialityService specialityService;

    @GetMapping("")
    public ResponseEntity<List<Speciality>> getALLSpeciality() {

        List<Speciality> specialities = specialityService.getSpecialities();

        return new ResponseEntity<>(specialities, HttpStatus.OK);

    }

    @GetMapping("/{id}")

    public ResponseEntity<Speciality> getSpecialityById(@PathVariable("id") long id) {

        Optional<Speciality> SpecialityId = specialityService.getSpecialityId(id);

        return new ResponseEntity<>(SpecialityId.get(), HttpStatus.OK);
    }

    @PostMapping("")

    public ResponseEntity<Speciality> createSpeciality(@Validated @RequestBody SpecialityDto specialityDto) {

        Speciality Speciality = specialityService.createSpeciality(specialityDto);

        return new ResponseEntity<>(Speciality, HttpStatus.OK);
    }

    @PutMapping("/{id}")

    public ResponseEntity<Speciality> updateSpeciality(@PathVariable("id") long id, @RequestBody SpecialityDto specialityDto) {

        Speciality newUpdateSpeciality = specialityService.updateSpeciality(id, specialityDto);

        return new ResponseEntity<>(newUpdateSpeciality, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    //suppression en fonction de l'id
    public ResponseEntity<HttpStatus> deleteSpeciality(@Validated @RequestBody @PathVariable("id") long id) {

        specialityService.deleteSpecialityId(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("")

    public ResponseEntity<HttpStatus> deleteAllSpeciality() {

        specialityService.deleteSpecialities();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
