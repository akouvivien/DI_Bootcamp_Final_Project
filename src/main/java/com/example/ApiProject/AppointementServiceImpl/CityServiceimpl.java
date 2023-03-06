package com.example.ApiProject.AppointementServiceImpl;

import com.example.ApiProject.Dto.CityDto;
import com.example.ApiProject.Service.CityService;
import com.example.ApiProject.model.*;
import com.example.ApiProject.repository.CityRepository;
import com.example.ApiProject.repository.HospitalRepository;
import com.example.ApiProject.repository.MunicipalityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceimpl  implements CityService {
    @Autowired
    CityRepository cityrepo;

    @Autowired
    MunicipalityRepository municipalityRepo;
    
    @Override
    public City createCity(CityDto cityDto) {

        Municipality municipality = municipalityRepo.findById(cityDto.getMunicipalitiesID()).orElse(null);
        if(municipality == null) throw new ApplicationContextException("ce la municipalité selectionner n'existe pas");

        // create city
        City addCity = new City();
        addCity.setName(cityDto.getName());;
        addCity.setMunicipalities((List<Municipality>) municipality);
        cityrepo.save(addCity);


        return addCity;
    }

    @Override
    public City updateCity(Long id, CityDto cityDto) {
        City cityToUpdate = cityrepo.findById(id).orElse(null);

        if(cityToUpdate !=null){

            BeanUtils.copyProperties(cityrepo, cityToUpdate, "id");

            cityrepo.save(cityToUpdate);
        }
        return cityrepo.save(cityToUpdate);
    }

    @Override
    public void deleteCityId(Long id) {

        cityrepo.deleteById(id);

    }

    @Override
    public Optional<City> getCityId(Long id) {

        Optional<City> cityid = cityrepo.findById(id);

        return cityid;
    }

    @Override
    public List<City> getCities() {
        return cityrepo.findAll();
    }

    @Override
    public void deleteCities() {
        cityrepo.deleteAll();

    }
}
