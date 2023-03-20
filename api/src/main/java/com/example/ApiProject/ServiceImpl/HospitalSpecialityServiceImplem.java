package com.example.ApiProject.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import com.example.ApiProject.Dto.AssignationDto;
import com.example.ApiProject.Model.Hospital;
import com.example.ApiProject.Model.HospitalSpeciality;
import com.example.ApiProject.Model.Speciality;
import com.example.ApiProject.Repository.*;
import com.example.ApiProject.Service.HospitalSpecialityService;

@Service
public class HospitalSpecialityServiceImplem implements HospitalSpecialityService {

    @Autowired
    HospitalSpecialityRepository hospitalspe;

    @Autowired
    HospitalRepository hospre;

    @Autowired
    SpecilalityRepository srepo;

    @Override
    public HospitalSpeciality createHospitalSpeciality(AssignationDto assignationDto) {
    
        Hospital hospital = hospre.findById(assignationDto.getHospital()).orElse(null);
        if(hospital == null) throw new ApplicationContextException("ce docteur n'existe pas dans la bd");

        // Speciality speciality = sperep.findById(assignationDto.getSpeciality()).orElse(null);
        // if(speciality == null) throw new ApplicationContextException("cette specialité n'existe pas dans la bd");

        Speciality speciality = srepo.findById(assignationDto.getSpeciality()).orElse(null);
        if(speciality == null) throw new ApplicationContextException("cette specialité n'existe pas dans la bd");


    
        // creation une liason entre l'hopital et le medecin
        HospitalSpeciality addhospitalspeciality = new HospitalSpeciality();

        addhospitalspeciality.setHospital(hospital);
        addhospitalspeciality.setSpeciality(speciality); 
        
        return hospitalspe.save(addhospitalspeciality);

    }

    @Override
    public List<HospitalSpeciality> getHospitalSpeciality() {
   
        return  hospitalspe.findAll();
   
    }

    @Override
    public Optional<HospitalSpeciality> getHospitalSpecialityId(Long id) {

        return  hospitalspe.findById(id);
    }

    @Override
    public void DeleteHospitalSpecialityId(Long id) {
      
        hospitalspe.deleteById(id);
    
    }

    @Override
    public void deleteHospitalSpeciality() {
         
          hospitalspe.deleteAll();

    }

    @Override
    public HospitalSpeciality updateHospitalSpeciality(Long id, AssignationDto assignationDto) {

        HospitalSpeciality hs = hospitalspe.findById(id).orElse(null);

		if(hs !=null){

			BeanUtils.copyProperties(hospitalspe, hs, "id");

			hospitalspe.save(hs);
		}
		return hospitalspe.save(hs);

    }
    @Override
    public List<HospitalSpeciality> getbyspecialities(Speciality speciality) {
        
        return hospitalspe.findAllBySpeciality(speciality);
    }

    @Override
    public List<HospitalSpeciality> getbyHospitals(Hospital hospital) {
       
        return  hospitalspe.findAllByHospital(hospital);
    }
    
}
