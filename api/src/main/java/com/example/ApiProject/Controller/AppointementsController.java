package com.example.ApiProject.Controller;

import com.example.ApiProject.Dto.AppointementDto;
import com.example.ApiProject.Model.Appointements;
import com.example.ApiProject.Service.AppointementsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/appointements")
public class AppointementsController {

    @Autowired
    AppointementsService appoService;

    @GetMapping("")
    public ResponseEntity<List<Appointements>> getALLAppointements(){
    	
    	List<Appointements> list = appoService.getAppointements() ;
        
         return new ResponseEntity<>(list, HttpStatus.OK);
        
    }

    @GetMapping("/{id}")

    public ResponseEntity<Appointements> getAppointementsById(@PathVariable("id") Long id) {

        Optional<Appointements> appointementsId =  appoService.getAppointementId(id);

        return new ResponseEntity<>(appointementsId.get(), HttpStatus.OK);
        }

    @PostMapping("")
    public ResponseEntity<String> createAppointements(@Validated @RequestBody AppointementDto appointementdto) {

        appoService.createAppointement(appointementdto);

        return new ResponseEntity<>("Enregistrement effectué avec succès !",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    //modification via l'id
   public ResponseEntity<Appointements> updateAppointements(@PathVariable("id") Long id, @RequestBody AppointementDto appointementdto) {

        Appointements newUpdateAppointements = appoService.updateAppointement(id, appointementdto);

        return new ResponseEntity<>(newUpdateAppointements, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<String> deleteAppointements(@Validated @RequestBody  @PathVariable("id") long id) {

        appoService.DeleteAppointementId(id);

        return new ResponseEntity<>("Suppression effectuer  avec succes !",HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("")

    public ResponseEntity<String> deleteAllAppointements() {

             appoService.deleteAppointements();

            return new ResponseEntity<>("L'ensemble des données a éte effacer avec succes !",HttpStatus.NO_CONTENT);

    }
}