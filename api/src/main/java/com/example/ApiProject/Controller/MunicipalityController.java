package com.example.ApiProject.Controller;

import com.example.ApiProject.Dto.MunicipalityDto;
import com.example.ApiProject.Model.Municipality;
import com.example.ApiProject.Service.MunicipalityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Validated
@RestController
@RequestMapping("/municipality")

public class MunicipalityController {

    @Autowired
    MunicipalityService municipalityService;
    @GetMapping("")
    public ResponseEntity<List<Municipality>> getALLCity(){

        List<Municipality> cities = municipalityService.getMunicipalities();

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Municipality> getMunicipalityById(@PathVariable("id") long id) {

        Optional<Municipality> municipalityId =  municipalityService.getMunicipalityId(id);

        return new ResponseEntity<>(municipalityId.get(), HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<String> createMunicipality(@Validated @RequestBody MunicipalityDto municipalityDto) {

        municipalityService.createMunicipality(municipalityDto);

        return new ResponseEntity<>("Enregistrement effectué avec succès !",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    //modification via l'id
    public ResponseEntity<Municipality> updateMunicipality(@PathVariable("id") long id, @RequestBody MunicipalityDto municipalityDto)
    {
        Municipality newUpdateMunicipality = municipalityService.updateMunicipality(id, municipalityDto);

        return new ResponseEntity<>(newUpdateMunicipality, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    //suppression en fonction de l'id
    public ResponseEntity<HttpStatus> deleteCity(@Validated @RequestBody  @PathVariable("id") long id) {

        municipalityService.deleteMunicipalityId(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("")
    //suppression de l'ensemble des données
    public ResponseEntity<HttpStatus> deleteAllCity() {

        municipalityService.deleteMunicipalities();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
