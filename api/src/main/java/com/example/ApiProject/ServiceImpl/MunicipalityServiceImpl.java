package com.example.ApiProject.serviceImpl;

import com.example.ApiProject.Dto.MunicipalityDto;
import com.example.ApiProject.Model.City;
import com.example.ApiProject.Model.Municipality;
import com.example.ApiProject.Repository.CityRepository;
import com.example.ApiProject.Repository.MunicipalityRepository;
import com.example.ApiProject.Service.MunicipalityService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipalityServiceImpl implements MunicipalityService {

    @Autowired
    MunicipalityRepository municipalityRepo;

    @Autowired
    CityRepository cityRepo;

    @Override
    public Municipality createMunicipality(MunicipalityDto municipalityDto) {

        City city = cityRepo.findById(municipalityDto.getCityId()).orElse(null);

        if(city == null) throw new ApplicationContextException("la Ville selectionnée n'existe pas");

        Municipality addMunicipality = new Municipality();

        addMunicipality.setName(municipalityDto.getName());

        addMunicipality.setCity(city);

        municipalityRepo.save(addMunicipality);

        return addMunicipality;
    }



    @Override
    public Municipality updateMunicipality(Long id, MunicipalityDto municipalityDto) {

        Municipality MunicipalityToUpdate = municipalityRepo.findById(id).orElse(null);

        if(MunicipalityToUpdate !=null){

            BeanUtils.copyProperties(municipalityRepo, MunicipalityToUpdate, "id");

            municipalityRepo.save(MunicipalityToUpdate);
        }
        return municipalityRepo.save(MunicipalityToUpdate);
    }



    @Override
    public void deleteMunicipalityId(Long id) {

        municipalityRepo.deleteById(id);

    }

    @Override
    public Optional<Municipality> getMunicipalityId(Long id) {

        Optional<Municipality> municipalityid = municipalityRepo.findById(id);
        
        return municipalityid;
    }

    @Override
    public List<Municipality> getMunicipalities() {

        return  municipalityRepo.findAll();
    }

    @Override
    public void deleteMunicipalities() {

        municipalityRepo.deleteAll();

    }
}
