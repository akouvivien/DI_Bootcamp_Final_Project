package com.example.ApiProject.Service;

import com.example.ApiProject.Dto.SpecialityHospitalDto;
import com.example.ApiProject.model.SpecialityHospital;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SpecialityHospitalService {

    SpecialityHospital createSpecialityHospital(SpecialityHospitalDto  specialityHospitalDto);

    SpecialityHospital updateSpecialityHospital(Long id, SpecialityHospitalDto  specialityHospitalDto);

    void deleteSpecialityHospitalId(Long id);

    Optional<SpecialityHospital> getSpecialityHospitalId(Long id);

    List<SpecialityHospital> getSpecialityHospitals();

    void deleteSpecialityHospitals();

}
