package com.example.ApiProject.Controller;

import com.example.ApiProject.Dto.CityDto;
import com.example.ApiProject.Model.City;
import com.example.ApiProject.Service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/city")

public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("")
    public ResponseEntity<List<City>> getALLCity(){

        List<City> cities = cityService.getCities() ;

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
    

    @GetMapping("/{id}")


    public ResponseEntity<City> getCityById(@PathVariable("id") long id) {

        Optional<City> cityId =  cityService.getCityId(id);

        return new ResponseEntity<>(cityId.get(), HttpStatus.OK);
    }
    

//     @GetMapping("/{name}")
// //recuperation de la ville via le nom
//     public ResponseEntity<City> getCityByName(@PathVariable("name") String name) {

//         Optional<City> cityName=  cityService.getCityName(name);

//         return new ResponseEntity<>(cityName.get(), HttpStatus.OK);
//     }


    @PostMapping("")
    public ResponseEntity<String> createCity(@Validated @RequestBody CityDto cityDto) {

        cityService.createCity(cityDto);

        return new ResponseEntity<>("Enregistrement effectué avec succès !",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    //modification via l'id
    public ResponseEntity<City> updateCityId(@PathVariable("id") Long id, @RequestBody CityDto cityDto)
    {
        City newUpdateCity = cityService.updateCity(id, cityDto);

        return new ResponseEntity<>(newUpdateCity, HttpStatus.OK);
    }

    // @PutMapping("/{name}")
    // //modification via le nom
    // public ResponseEntity<City> updateCityName(@PathVariable("name") String name, @RequestBody CityDto cityDto)
    // {
    //     City newUpdateCity = cityService.updateCityName(name, cityDto);

    //     return new ResponseEntity<>(newUpdateCity, HttpStatus.OK);
    // }

    @DeleteMapping("/{id}")
    //suppression en fonction de l'id
    public ResponseEntity<HttpStatus> deleteCity(@Validated @RequestBody  @PathVariable("id") long id) {

        cityService.deleteCityId(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("")
    //suppression de l'ensemble des données
    public ResponseEntity<HttpStatus> deleteAllCity() {

            cityService.deleteCities();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
