package com.example.ApiProject.AppointementServiceImpl;

import com.example.ApiProject.Dto.SpecialityHospitalDto;
import com.example.ApiProject.Service.SpecialityHospitalService;
import com.example.ApiProject.model.*;
import com.example.ApiProject.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SpecialityHospitalServiceImpl implements SpecialityHospitalService {

    @Autowired
    SpecialityHospitalRepository spehosRepo;

    @Autowired
    DoctorRepository doctorRepo;

    @Autowired
    SpecilalityRepository specilalityRepo;

    @Autowired
    HospitalRepository hospitalRepo;

    @Override
    public SpecialityHospital createSpecialityHospital(SpecialityHospitalDto specialityHospitalDto) {

        // selectionner un hopital
        Hospital hospital = hospitalRepo.findById(specialityHospitalDto.getHospitalId()).orElse(null);

        if(hospital == null) throw new ApplicationContextException("l'hopital selectionné n'existe pas");

        // selectionner une specialité
        Speciality speciality = specilalityRepo.findById(specialityHospitalDto.getSpecialityId()).orElse(null);

        if(speciality == null) throw new ApplicationContextException("la specialité selectionnée n'existe pas");

        //selectionner un doctor
        Doctor doctor = doctorRepo.findById(specialityHospitalDto.getDoctorId()).orElse(null);

        if(doctor == null) throw new ApplicationContextException("la specialité selectionnée n'existe pas");


        // assigner un docteur a un hopital et a  une specialité
        SpecialityHospital addSpecialityHospital = new SpecialityHospital();

        addSpecialityHospital.setHospital(hospital);

        addSpecialityHospital.setDoctor(doctor);

        addSpecialityHospital.setSpeciality(speciality);

        spehosRepo.save(addSpecialityHospital);


        return addSpecialityHospital;
    }

    @Override
    public SpecialityHospital updateSpecialityHospital(Long id, SpecialityHospitalDto specialityHospitalDto) {

        SpecialityHospital SpecialityHospitalToUpdate = spehosRepo.findById(id).orElse(null);

        if(SpecialityHospitalToUpdate !=null){

            BeanUtils.copyProperties(spehosRepo, SpecialityHospitalToUpdate, "id");

            spehosRepo.save(SpecialityHospitalToUpdate);
        }
        return spehosRepo.save(SpecialityHospitalToUpdate);
    }

    @Override
    public void deleteSpecialityHospitalId(Long id) {

        spehosRepo.deleteById(id);
    }

    @Override
    public Optional<SpecialityHospital> getSpecialityHospitalId(Long id) {

        return spehosRepo.findById(id);
    }

    @Override
    public List<SpecialityHospital> getSpecialityHospitals() {

        return spehosRepo.findAll();
    }

    @Override
    public void deleteSpecialityHospitals() {

        spehosRepo.deleteAll();

    }
}
