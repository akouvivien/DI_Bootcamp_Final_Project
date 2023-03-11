package com.example.ApiProject.serviceImpl;
import com.example.ApiProject.Dto.DoctorDto;
import com.example.ApiProject.Model.*;
import com.example.ApiProject.Repository.DoctorRepository;
import com.example.ApiProject.Repository.RolesRepository;
import com.example.ApiProject.Service.DoctorService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl  implements DoctorService {
    @Autowired
    DoctorRepository doctorRepo;

    @Autowired
    RolesRepository rolesRepo;

    @Override
    public Doctor CreateDoctor(DoctorDto doctorDto) {

        Doctor addDoctor = new Doctor();

        addDoctor.setFirst_name(doctorDto.getFirst_name());

        addDoctor.setLast_name(doctorDto.getLast_name());

        addDoctor.setAdresse(doctorDto.getAddress());

        addDoctor.setLogin(doctorDto.getLogin());

        addDoctor.setEmail(doctorDto.getEmail());

        addDoctor.setMdPasse(doctorDto.getPassword());

        Roles roles = rolesRepo.findByName("Doctor").get();

        addDoctor.setRoles(roles);

        addDoctor.setDoctor_status(doctorDto.isDoctor_status());

        addDoctor.setPhone_number(doctorDto.getPhone_number());

        addDoctor.setMatricule(doctorDto.getMatricule());

        doctorRepo.save(addDoctor);

        return addDoctor;
    }

    @Override
    public Doctor UpdateDoctorId(Long id, DoctorDto doctorDto) {

        Doctor doctorToUpdate = doctorRepo.findById(id).orElse(null);

        if(doctorToUpdate !=null){

            BeanUtils.copyProperties(doctorRepo, doctorToUpdate, "id");

            doctorRepo.save(doctorToUpdate);
        }
        return doctorRepo.save(doctorToUpdate);
    }

    @Override
    public void deleteDoctorId(Long id) {

        doctorRepo.deleteById(id);

    }

    @Override
    public Optional<Doctor> getDoctorId(Long id) {

        Optional<Doctor> doctorid = doctorRepo.findById(id);

        return doctorid;
    }

    @Override
    public List<Doctor> getDoctors() {

        return doctorRepo.findAll();
    }

    @Override
    public void deleteDoctors() {

        doctorRepo.deleteAll();
    }
}
