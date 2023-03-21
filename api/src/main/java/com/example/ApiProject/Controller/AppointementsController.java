package com.example.ApiProject.Controller;

import com.example.ApiProject.Dto.AppointementDto;
import com.example.ApiProject.Model.Appointements;
import com.example.ApiProject.Model.Patient;
import com.example.ApiProject.Model.Doctor;
import com.example.ApiProject.Model.Hospital;
import com.example.ApiProject.Service.AppointementsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@CrossOrigin(origins = "*", allowedHeaders="*")
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
    public ResponseEntity<Appointements> createAppointements(@Validated @RequestBody AppointementDto appointementdto) {

        appoService.createAppointement(appointementdto);

        return new ResponseEntity<>(appoService.createAppointement(appointementdto),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    //modification via l'id
   public ResponseEntity<Appointements> updateAppointements(@PathVariable("id") Long id, @RequestBody AppointementDto appointementdto) {

        Appointements newUpdateAppointements = appoService.updateAppointement(id, appointementdto);

        return new ResponseEntity<>(newUpdateAppointements, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<String> deleteAppointements(@Validated @RequestBody  @PathVariable("id") Long id) {

        appoService.DeleteAppointementId(id);

        return new ResponseEntity<>("Suppression effectuer  avec succes !",HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("")

    public ResponseEntity<String> deleteAllAppointements() {

             appoService.deleteAppointements();

            return new ResponseEntity<>("L'ensemble des données a éte effacer avec succes !",HttpStatus.NO_CONTENT);

    }
//a rectifier
    @PostMapping("/getpatient")

    public ResponseEntity<List<Appointements>> shearchPatient(@RequestBody Patient patient) {

        return new ResponseEntity<>(appoService.getbyNameInAppointements(patient),HttpStatus.OK);

    }

    // @PostMapping("/get")

    // public ResponseEntity<List<Appointements>> shearchByPatientHospital(@RequestBody AppointementDto appointementDto) {

    //     return new ResponseEntity<>(appoService.getbyPatientAndHospital(appointementDto),HttpStatus.OK);

    // }


    @PostMapping("/gethospital")

    public ResponseEntity<List<Appointements>> shearchByHospital(@RequestBody Hospital hospital) {

        return new ResponseEntity<>(appoService.getbyHospital(hospital),HttpStatus.OK);

    }

}