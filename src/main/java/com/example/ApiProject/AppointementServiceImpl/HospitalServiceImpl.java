package com.example.ApiProject.AppointementServiceImpl;

import com.example.ApiProject.Dto.HospitalDto;
import com.example.ApiProject.Service.HospitalService;
import com.example.ApiProject.model.Hospital;
import com.example.ApiProject.repository.HospitalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;

    @Override
    public Hospital CreateHospital(HospitalDto hospitalDto) {

        Hospital addHospital = new Hospital();

        addHospital.setName(hospitalDto.getName());

        addHospital.setAdresse(hospitalDto.getAdresse());

        addHospital.setStatus(hospitalDto.isStatus());

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
}
