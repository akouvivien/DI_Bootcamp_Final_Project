package com.example.ApiProject.AppointementServiceImpl;

import com.example.ApiProject.Dto.PatientDto;
import com.example.ApiProject.Service.PatientService;
import com.example.ApiProject.model.Patient;
import com.example.ApiProject.repository.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl  implements PatientService {

    @Autowired
    PatientRepository patientRepo;


    @Override
    public Patient createPatient(PatientDto patientDto) {

        Patient addPatient = new Patient();

        addPatient.setFirst_name(patientDto.getFirst_name());

        addPatient.setLast_name(patientDto.getLast_name());

        addPatient.setAdresse(patientDto.getAddress());

        addPatient.setLogin(patientDto.getLogin());

        addPatient.setMdPasse(patientDto.getMdPasse());

        addPatient.setPhone_number(patientDto.getPhone_number());

        patientRepo.save(addPatient);

        return addPatient;

    }

    @Override
    public Patient updatePatient(Long id, PatientDto patientDto) {

        Patient patientToUpdate = patientRepo.findById(id).orElse(null);

        if(patientToUpdate !=null){

            BeanUtils.copyProperties(patientDto, patientToUpdate, "id");

            patientRepo.save(patientToUpdate);
        }
        return patientRepo.save(patientToUpdate);
    }

    @Override
    public void deletePatientId(Long id) {

        patientRepo.deleteById(id);
    }

    @Override
    public Optional<Patient> getPatientId(Long id) {
        Optional<Patient> patientid = patientRepo.findById(id);
        return patientid;
    }

    @Override
    public List<Patient> getPatients() {

        return patientRepo.findAll();
    }

    @Override
    public void deletePatients() {
        patientRepo.deleteAll();
    }
}
