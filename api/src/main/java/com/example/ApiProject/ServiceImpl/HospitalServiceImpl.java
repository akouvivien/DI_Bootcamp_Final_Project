package com.example.ApiProject.serviceImpl;

import com.example.ApiProject.Dto.CityDto;
import com.example.ApiProject.Dto.ContryDto;
import com.example.ApiProject.Dto.HospitalDto;
import com.example.ApiProject.Dto.MunicipalityDto;
import com.example.ApiProject.Model.EtablissementCategory;
import com.example.ApiProject.Model.Hospital;
import com.example.ApiProject.Model.Municipality;
import com.example.ApiProject.Repository.EtablissementRepository;
import com.example.ApiProject.Repository.HospitalRepository;
import com.example.ApiProject.Repository.MunicipalityRepository;
import com.example.ApiProject.Service.HospitalService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;

    @Autowired
    MunicipalityRepository municipalityRepo;

    @Autowired
    EtablissementRepository etablissementRepo;

    @Override
    public Hospital CreateHospital(HospitalDto hospitalDto) {

        Municipality municipality = municipalityRepo.findById(hospitalDto.getMunicipalityId()).orElse(null);
        if(municipality == null) throw new ApplicationContextException("la municipalité selectionnée n'existe pas");

        EtablissementCategory etablissementCategory = etablissementRepo.findById(hospitalDto.getEtablissementCategoryId()).orElse(null);
        if(etablissementCategory == null) throw new ApplicationContextException("la category selectionnée n'existe pas");

        Hospital addHospital = new Hospital();

        addHospital.setName(hospitalDto.getName());

        addHospital.setAdresse(hospitalDto.getAdresse());

        addHospital.setMunicipality(municipality);

        addHospital.setEtablissementCategory(etablissementCategory);

        hospitalRepository.save(addHospital);

        return addHospital;

    }

    @Override
    public Hospital UpdateHospitalId(Long id, HospitalDto hospitalDto) {

        Hospital hospitalToUpdate = hospitalRepository.findById(id).orElse(null);

        if(hospitalToUpdate !=null){

            BeanUtils.copyProperties(hospitalRepository, hospitalToUpdate, "id");

            hospitalRepository.save(hospitalToUpdate);
        }
        return hospitalRepository.save(hospitalToUpdate);
    }

    @Override
    public void deleteHospitalId(Long id) {

        hospitalRepository.deleteById(id);

    }

    @Override
    public Optional<Hospital> getHospitalId(Long id) {

        return Optional.empty();

    }

    @Override
    public List<Hospital> getHospitals() {

        return hospitalRepository.findAll();

    }

    @Override

    public void deleteHospitals() {

        hospitalRepository.deleteAll();

    }

    // @Override
    // public List<Hospital> findHospitalByCritary(ContryDto contrydto, CityDto citydto, MunicipalityDto municipalitydto, String Status) {
    //     // TODO a corriger pour le status et a revoir la methode
    //     return hospitalRepository.findHospitalByCritary(contrydto, citydto, municipalitydto, Status) ;
    // }
}
