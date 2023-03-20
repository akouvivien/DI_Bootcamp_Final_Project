package com.example.ApiProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ApiProject.Dto.AssignationDto;
import com.example.ApiProject.Model.Hospital;
import com.example.ApiProject.Model.HospitalSpeciality;
import com.example.ApiProject.Model.Speciality;

@Service
public interface HospitalSpecialityService {


    HospitalSpeciality createHospitalSpeciality(AssignationDto assignationDto);

    List<HospitalSpeciality> getHospitalSpeciality();

    Optional<HospitalSpeciality> getHospitalSpecialityId(Long id);

    void DeleteHospitalSpecialityId(Long id);

    void deleteHospitalSpeciality();

    HospitalSpeciality updateHospitalSpeciality(Long id, AssignationDto assignationDto);

    //recherche par specialite
    List<HospitalSpeciality> getbyspecialities(Speciality speciality);

    //recherche par patient et hopital
    // List<HospitalDoctor> getbyall(AssignationDto assignationDto);

    //recherche par hopital
    List<HospitalSpeciality> getbyHospitals(Hospital hospital);
    
}
