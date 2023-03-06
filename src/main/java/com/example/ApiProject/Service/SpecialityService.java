package com.example.ApiProject.Service;
import com.example.ApiProject.Dto.SpecialityDto;
import com.example.ApiProject.model.Speciality;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface SpecialityService {

    Speciality createSpeciality(SpecialityDto specialityDto) ;

    Speciality updateSpeciality(Long id, SpecialityDto specialityDto);

    void deleteSpecialityId(Long id);

    Optional<Speciality> getSpecialityId(Long id);


    List<Speciality> getSpecialities();

    void deleteSpecialities();
}
