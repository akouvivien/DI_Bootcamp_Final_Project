package com.example.ApiProject.serviceImpl;

import com.example.ApiProject.Dto.SpecialityHospitalDoctorDto;
import com.example.ApiProject.Model.*;
import com.example.ApiProject.Repository.*;
import com.example.ApiProject.Service.SpecialityHospitalDoctorService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SpecialityHospitalDoctorServiceImpl implements SpecialityHospitalDoctorService {

    @Autowired
    SpecialityHospitalDoctorRepository spehosdocRepo;

    @Autowired
    DoctorRepository doctorRepo;

    @Autowired
    SpecilalityRepository specilalityRepo;

    @Autowired
    HospitalRepository hospitalRepo;

    @Override
    public SpecialityHospitalDoctor createSpecialityHospital(SpecialityHospitalDoctorDto specialityHospitalDoctorDto) {

        // selectionner un hopital
        Hospital hospital = hospitalRepo.findById(specialityHospitalDoctorDto.getHospitalId()).orElse(null);

        if(hospital == null) throw new ApplicationContextException("l'hopital selectionné n'existe pas");

        // selectionner une specialité
        Speciality speciality = specilalityRepo.findById(specialityHospitalDoctorDto.getSpecialityId()).orElse(null);

        if(speciality == null) throw new ApplicationContextException("la specialité selectionnée n'existe pas");

        //selectionner un doctor
        Doctor doctor = doctorRepo.findById(specialityHospitalDoctorDto.getDoctorId()).orElse(null);

        if(doctor == null) throw new ApplicationContextException("la docteur selectionné n'existe pas");


        // assigner un docteur a un hopital et a  une specialité
        SpecialityHospitalDoctor addSpecialityHospitalDoctor = new SpecialityHospitalDoctor();

        addSpecialityHospitalDoctor.setHospital(hospital);

        addSpecialityHospitalDoctor.setDoctor(doctor);

        addSpecialityHospitalDoctor.setSpeciality(speciality);

        spehosdocRepo.save(addSpecialityHospitalDoctor);


        return addSpecialityHospitalDoctor;
    }

    @Override
    public SpecialityHospitalDoctor updateSpecialityHospital(Long id, SpecialityHospitalDoctorDto specialityHospitalDoctorDto) {

        SpecialityHospitalDoctor SpecialityHospitalToUpdate = spehosdocRepo.findById(id).orElse(null);

        if(SpecialityHospitalToUpdate !=null){

            BeanUtils.copyProperties(spehosdocRepo, SpecialityHospitalToUpdate, "id");

            spehosdocRepo.save(SpecialityHospitalToUpdate);
        }
        return spehosdocRepo.save(SpecialityHospitalToUpdate);
    }

    @Override
    public void deleteSpecialityHospitalId(Long id) {

        spehosdocRepo.deleteById(id);
    }

    @Override
    public Optional<SpecialityHospitalDoctor> getSpecialityHospitalId(Long id) {

        return spehosdocRepo.findById(id);
    }

    @Override
    public List<SpecialityHospitalDoctor> getSpecialityHospitals() {

        return spehosdocRepo.findAll();
    }

    @Override
    public void deleteSpecialityHospitals() {

        spehosdocRepo.deleteAll();

    }
}
