package com.example.ApiProject.serviceImpl;

import com.example.ApiProject.Dto.SpecialityDto;
import com.example.ApiProject.Model.Speciality;
import com.example.ApiProject.Repository.SpecilalityRepository;
import com.example.ApiProject.Service.SpecialityService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SpecialityServiceImpl implements SpecialityService {
    @Autowired
    SpecilalityRepository specilalityRepo ;

    @Override
    public Speciality createSpeciality(SpecialityDto specialityDto) {

        Speciality addSpeciality = new Speciality();

        addSpeciality.setName(specialityDto.getName());

         specilalityRepo.save(addSpeciality);

         return addSpeciality;
    }

    @Override
    public Speciality updateSpeciality(Long id, SpecialityDto specialityDto) {
        Speciality specialityToUpdate = specilalityRepo.findById(id).orElse(null);

        if(specialityToUpdate !=null){

            BeanUtils.copyProperties(specilalityRepo, specialityToUpdate, "id");

            specilalityRepo.save(specialityToUpdate);
        }
        return specilalityRepo.save(specialityToUpdate);
    }

    @Override
    public void deleteSpecialityId(Long id) {

        specilalityRepo.deleteById(id);
    }

    @Override
    public Optional<Speciality> getSpecialityId(Long id) {

        Optional<Speciality> SpecialityId = specilalityRepo.findById(id);

        return SpecialityId;
    }

    @Override
    public List<Speciality> getSpecialities() {

        return specilalityRepo.findAll();

    }

    @Override
    public void deleteSpecialities() {

       specilalityRepo.deleteAll();

    }
}
