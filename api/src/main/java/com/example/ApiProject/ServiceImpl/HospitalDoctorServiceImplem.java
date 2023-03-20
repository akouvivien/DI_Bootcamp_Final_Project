package com.example.ApiProject.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import com.example.ApiProject.Dto.AssignationDto;
import com.example.ApiProject.Model.*;
import com.example.ApiProject.Repository.DoctorRepository;
import com.example.ApiProject.Repository.HospitalDoctorRepository;
import com.example.ApiProject.Repository.HospitalRepository;
import com.example.ApiProject.Repository.HospitalSpecialityRepository;
import com.example.ApiProject.Repository.SpecilalityRepository;
import com.example.ApiProject.Service.HospitalDoctorService;

@Service
public class HospitalDoctorServiceImplem  implements HospitalDoctorService{
    
    @Autowired
    HospitalDoctorRepository hsdrep;

    // @Autowired
    // HospitalSpecialityRepository hsp;

    @Autowired
    HospitalRepository hospre;

    // @Autowired
    // SpecilalityRepository sperep;

    // @Autowired
    // HospitalRepository hosptalrep;

    @Autowired
    DoctorRepository docrep;

    @Override
    public HospitalDoctor createHospitalDoctor(AssignationDto assignationDto) {
        

        Hospital hospital = hospre.findById(assignationDto.getHospital()).orElse(null);
        if(hospital == null) throw new ApplicationContextException("ce docteur n'existe pas dans la bd");

        // Speciality speciality = sperep.findById(assignationDto.getSpeciality()).orElse(null);
        // if(speciality == null) throw new ApplicationContextException("cette specialité n'existe pas dans la bd");

        Doctor doctor = docrep.findById(assignationDto.getDoctor()).orElse(null);
        if(doctor == null) throw new ApplicationContextException("ce docteur n'existe pas dans la bd");


    
        // creation une liason entre l'hopital et le medecin
        HospitalDoctor addhospitalDoctor = new HospitalDoctor();

        addhospitalDoctor.setHospital(hospital);
        addhospitalDoctor.setDoctor(doctor); 
        hsdrep.save(addhospitalDoctor);


        //choisir un hopital et une specialisation
        // HospitalSpeciality Hospitalspeciality = new HospitalSpeciality();
        // Hospitalspeciality.setHospital(hospital);
        // Hospitalspeciality.setSpeciality(speciality);

        // hsp.save(Hospitalspeciality);

            return  addhospitalDoctor;
    }

    @Override
    public List<HospitalDoctor> getHospitalDoctors() {
      
        return  hsdrep.findAll();
    
    }

    @Override
    public Optional<HospitalDoctor> getHospitalDoctorId(Long id) {


            return  hsdrep.findById(id);
    }

    @Override
    public void DeleteHospitalDoctorId(Long id) {
       
         hsdrep.deleteById(id);

    }

    @Override
    public void deleteHospitalDoctors() {
 
         hsdrep.deleteAll();
    }

    @Override
    public HospitalDoctor updateHospitalDoctor(Long id, AssignationDto assignationDto) {
       
        HospitalDoctor HospitalDoctorToUpdate = hsdrep.findById(id).orElse(null);

		if(HospitalDoctorToUpdate !=null){

			BeanUtils.copyProperties(hsdrep, HospitalDoctorToUpdate, "id");

			hsdrep.save(HospitalDoctorToUpdate);
		}
		return hsdrep.save(HospitalDoctorToUpdate);

    }

    @Override
    public List<HospitalDoctor> getbyDoctors(Doctor doctor) {

        return hsdrep.findAllByDoctor(doctor);
    }

    @Override
    public List<HospitalDoctor> getbyHospital(Hospital hospital) {
        
        return hsdrep.findAllByHospital(hospital);
    }
    
}
