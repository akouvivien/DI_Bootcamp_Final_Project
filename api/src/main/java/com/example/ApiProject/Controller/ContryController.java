package com.example.ApiProject.Controller;

import com.example.ApiProject.Dto.ContryDto;
import com.example.ApiProject.Model.Contry;
import com.example.ApiProject.Service.ContryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/contry")

public class ContryController {

    @Autowired
    ContryService contryService;

    @GetMapping("")
    public ResponseEntity<List<Contry>> getALLContry() {

        List<Contry> contry = contryService.getContries();

        return new ResponseEntity<>(contry, HttpStatus.OK);

    }

    @GetMapping("/{id}")

    public ResponseEntity<Contry> getContryById(@PathVariable("id") long id) {

        Optional<Contry> contriesid = contryService.getContryId(id);

        return new ResponseEntity<>(contriesid.get(), HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity<Contry> createContry(@Validated @RequestBody ContryDto contryDto) {

        Contry _contry = contryService.createContry(contryDto);

        return new ResponseEntity<>(_contry, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")

    public ResponseEntity<Contry> updateContry(@PathVariable("id") long id, @RequestBody Contry contry) {

        Optional<Contry> contryId = contryService.getContryId(id);

        return new ResponseEntity<>(contryId.get(), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")

    //suppression en fonction de l'id
    
    public ResponseEntity<HttpStatus> deleteContryId(@Validated @RequestBody @PathVariable("id") long id) {

        contryService.deleteContryId(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("")

    public ResponseEntity<HttpStatus> deleteAllContry() {

        contryService.deleteContries();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
