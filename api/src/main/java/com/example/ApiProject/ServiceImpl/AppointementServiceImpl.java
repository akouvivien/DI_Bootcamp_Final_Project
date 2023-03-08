package com.example.ApiProject.AppointementServiceImpl;


import java.util.List;
import java.util.Optional;

import com.example.ApiProject.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import com.example.ApiProject.Dto.AppointementDto;
import com.example.ApiProject.Service.AppointementsService;
import com.example.ApiProject.repository.AppointementsRepository;
import com.example.ApiProject.repository.HospitalRepository;
import com.example.ApiProject.repository.PatientRepository;
import com.example.ApiProject.repository.SpecialityHospitalRepository;
import com.example.ApiProject.repository.SpecilalityRepository;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AppointementServiceImpl implements AppointementsService {
	
	    @Autowired
	    PatientRepository patientRepo;

	    @Autowired
	    HospitalRepository hospitalRepo;

	    @Autowired
	    AppointementsRepository appoRepo;
	    
	    @Autowired
	    SpecilalityRepository specialityRepo;
	    
	    @Autowired
	    SpecialityHospitalRepository shRepo;

// creation d'un rdv selon un service predefinit et en fonction de la disponibilité du medcin (Jours)
	@Override
	public Appointements createAppointement(AppointementDto appointemetDto) {

		        Patient patient = patientRepo.findById(appointemetDto.getPatientId()).orElse(null);
		        if(patient == null) throw new ApplicationContextException("ce patient n'existe pas");

		        Hospital hopital = hospitalRepo.findById(appointemetDto.getHospitalId()).orElse(null);

		        Speciality speciality = specialityRepo.findById(appointemetDto.getSpecialityId()).orElse(null);

		        Appointements appByDate = appoRepo.findAllByDate(appointemetDto.getDate());
		        if(appByDate != null) throw new ApplicationContextException("Cette date est deja occupée par un autre rdv !");

				// creation d'un rdv
		        Appointements addAppointment = new Appointements();
		        addAppointment.setHospital(hopital);
		        addAppointment.setPatient(patient);
		        addAppointment.setDate(appointemetDto.getDate());
		        appoRepo.save(addAppointment);

				//choisir un hopital et une specialisation
		        SpecialityHospital specialityHospital = new SpecialityHospital();
		        specialityHospital.setHospital(hopital);
		        specialityHospital.setSpeciality(speciality);
		        shRepo.save(specialityHospital);

		return addAppointment;
	}


	@Override
	public List<Appointements> getAppointements() {

		return appoRepo.findAll();

	}

	@Override
	public Optional<Appointements> getAppointementId(Long id) {

		return appoRepo.findById(id);

	}

	@Override
	 public void DeleteAppointementId(Long id) {
		appoRepo.deleteById(id);
	}

	//modification du rdv a completer

	public Appointements updateAppointement(Long id, @RequestBody AppointementDto appointementDto) {
		Appointements AppointementsToUpdate = appoRepo.findById(id).orElse(null);

		if(AppointementsToUpdate !=null){

			BeanUtils.copyProperties(appoRepo, AppointementsToUpdate, "id");

			appoRepo.save(AppointementsToUpdate);
		}
		return appoRepo.save(AppointementsToUpdate);
	}


		@Override
		public void deleteAppointements () {

			appoRepo.deleteAll();

		}


	}