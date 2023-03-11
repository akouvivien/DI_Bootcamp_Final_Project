package com.example.ApiProject.Service;

import com.example.ApiProject.Dto.SpecialityHospitalDoctorDto;
import com.example.ApiProject.Model.SpecialityHospitalDoctor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SpecialityHospitalDoctorService {

    SpecialityHospitalDoctor createSpecialityHospital(SpecialityHospitalDoctorDto  specialityHospitalDoctorDto);

    SpecialityHospitalDoctor updateSpecialityHospital(Long id, SpecialityHospitalDoctorDto  specialityHospitalDoctorDto);

    void deleteSpecialityHospitalId(Long id);

    Optional<SpecialityHospitalDoctor> getSpecialityHospitalId(Long id);

    List<SpecialityHospitalDoctor> getSpecialityHospitals();

    void deleteSpecialityHospitals();

}
