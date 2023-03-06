package com.example.ApiProject.Controller;

import com.example.ApiProject.model.EtablissementCategory;
import com.example.ApiProject.repository.EtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/etablissementcategory")

public class EtablissementCategoryController {

    @Autowired
    EtablissementRepository etablissementRepository;

    @GetMapping("")
    public ResponseEntity<List<EtablissementCategory>> getALLEtablissementCategory(){
        //recupere la liste de tous les patients
        List<EtablissementCategory> etablissementcategories = new ArrayList<>();
        etablissementcategories.addAll(etablissementRepository.findAll());
        try {
            if (etablissementcategories.isEmpty()) {
                //retourne le statut no content lorsque la liste est vide
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            //la methode retourne la liste tutorials
            return new ResponseEntity<>(etablissementcategories, HttpStatus.OK);
        } catch (Exception e) {
            //retoune une execption
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    // le resultat de la methode est accessible via l'url definit ci dessus
    public ResponseEntity<EtablissementCategory> getEtablissementCategoryById(@PathVariable("id") long id) {
        //tutorialData retourne de resulat de findById
        Optional<EtablissementCategory> etablissementcategoryid = etablissementRepository.findById(id);

        if (etablissementcategoryid.isPresent()) {
            //si tutorialData est present alors on recupere l'ensemble des données  et on affiche ok
            return new ResponseEntity<>(etablissementcategoryid.get(), HttpStatus.OK);
        } else {
            //retourne un resultat not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<EtablissementCategory> createEtablissementCategory(@Validated @RequestBody EtablissementCategory etablissementcategory) {
        try {
            //_tutorial  est un enregistrement de Tutorials via son constructeur
            EtablissementCategory _etablissementCategory = etablissementRepository.save(etablissementcategory);
            return new ResponseEntity<>(_etablissementCategory, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    //modification via l'id
    public ResponseEntity<EtablissementCategory> updateEtablissementCategory(@PathVariable("id") long id, @RequestBody EtablissementCategory etablissementcategory)
    {
        Optional<EtablissementCategory> etablissementcategory_ = etablissementRepository.findById(id);
        // avoir
        if (etablissementcategory_.isPresent()) {

            etablissementcategory.setId(id);
            etablissementRepository.save(etablissementcategory);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            //return un not found pour signifier que l'id n'existe pas
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    //suppression en fonction de l'id
    public ResponseEntity<HttpStatus> deleteHospital(@Validated @RequestBody  @PathVariable("id") long id) {
        try {
            //suppression des données relatives a l'id dans le repertoire
            etablissementRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("")
    //suppression de l'ensemble des données
    public ResponseEntity<HttpStatus> deleteAllEtablissementCategory() {
        try {
            //suppression de toutes les données
            etablissementRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
