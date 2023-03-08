package com.example.ApiProject.Service;

import com.example.ApiProject.Dto.HospitalDto;
import com.example.ApiProject.Model.Hospital;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface HospitalService {

    Hospital CreateHospital(HospitalDto hospitalDto);

    Hospital UpdateHospitalId(Long id, HospitalDto hospitalDto);

    void deleteHospitalId(Long id);

    Optional<Hospital> getHospitalId(Long id);

    List<Hospital> getHospitals();

    void deleteHospitals();
}
