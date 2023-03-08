package com.example.ApiProject.Controller;

import com.example.ApiProject.Dto.EtablissementCategoryDto;
import com.example.ApiProject.Model.EtablissementCategory;
import com.example.ApiProject.Service.EtablissementCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Validated
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/categoory")
public class EtablissementCategoryController {
    @Autowired
    EtablissementCategoryService etablissementCategoryService;

    @GetMapping("")
    public ResponseEntity<List<EtablissementCategory>> getALLEtablissementCategories() {

        List<EtablissementCategory> etablissementCategories = etablissementCategoryService.getEtablissementCategories();

        return new ResponseEntity<>(etablissementCategories, HttpStatus.OK);

    }

    @GetMapping("/{id}")

    public ResponseEntity<EtablissementCategory> getEtablissementCategoryById(@PathVariable("id") Long id) {

        Optional<EtablissementCategory> etablissementCategoryId = etablissementCategoryService.getEtablissementCategoryId(id);

        return new ResponseEntity<>(etablissementCategoryId.get(), HttpStatus.OK);
    }

    @PostMapping("")

    public ResponseEntity<EtablissementCategory> createEtablissementCategory(@Validated @RequestBody EtablissementCategoryDto etablissementCategoryDto) {

        EtablissementCategory etablissementCategory = etablissementCategoryService.CreateEtablissementCategory(etablissementCategoryDto);

        return new ResponseEntity<>(etablissementCategory, HttpStatus.OK);
    }

    @PutMapping("/{id}")

    public ResponseEntity<EtablissementCategory> updateEtablissementCategory(@PathVariable("id") long id, @RequestBody EtablissementCategoryDto etablissementCategoryDto) {

        EtablissementCategory newUpdateEtablissementCategory = etablissementCategoryService.UpdateEtablissementCategoryId(id,etablissementCategoryDto);

        return new ResponseEntity<>(newUpdateEtablissementCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    //suppression en fonction de l'id
    public ResponseEntity<HttpStatus> deleteRole(@Validated @RequestBody @PathVariable("id") long id) {

        etablissementCategoryService.deleteEtablissementCategoryId(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("")

    public ResponseEntity<HttpStatus> deleteAllSpeciality() {

        etablissementCategoryService.deleteEtablissementCategories();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
