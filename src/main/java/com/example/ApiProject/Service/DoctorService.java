package com.example.ApiProject.Service;

import com.example.ApiProject.Dto.DoctorDto;
import com.example.ApiProject.model.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DoctorService {
    Doctor CreateDoctor(DoctorDto doctorDto);

    Doctor UpdateDoctorId(Long id, DoctorDto doctorDto);

    void deleteDoctorId(Long id);

    Optional<Doctor> getDoctorId(Long id);

    List<Doctor> getDoctors();

    void deleteDoctors();
}
