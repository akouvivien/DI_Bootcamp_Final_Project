package com.example.ApiProject.serviceImpl;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import com.example.ApiProject.Dto.AppointementDto;
import com.example.ApiProject.Dto.PatientDto;
import com.example.ApiProject.Enums.StatusAppointements;
import com.example.ApiProject.Model.*;
import com.example.ApiProject.Repository.AppointementsRepository;
import com.example.ApiProject.Repository.DoctorRepository;
import com.example.ApiProject.Repository.HospitalRepository;
import com.example.ApiProject.Repository.PatientRepository;
import com.example.ApiProject.Repository.SpecialityHospitalDoctorRepository;
import com.example.ApiProject.Repository.SpecilalityRepository;
import com.example.ApiProject.Service.AppointementsService;

import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AppointementServiceImpl implements AppointementsService {
	
	    @Autowired
	    PatientRepository patientRepo;

		@Autowired
	    DoctorRepository doctorRepo;

	    @Autowired
	    HospitalRepository hospitalRepo;

	    @Autowired
	    AppointementsRepository appoRepo;
	    
	    @Autowired
	    SpecilalityRepository specialityRepo;
	    
	    @Autowired
	    SpecialityHospitalDoctorRepository shRepo;

// creation d'un rdv selon un service predefinit et en fonction de la disponibilité du medcin (Jours)
	@Override
	public Appointements createAppointement(AppointementDto appointemetDto) {

				 // selectionner un pays

				 Patient patient = patientRepo.findById(appointemetDto.getPatientId()).orElse(null);
				 if(patient == null) throw new ApplicationContextException("ce patient n'existe pas");

				 Doctor doctor = doctorRepo.findById(appointemetDto.getDoctorId()).orElse(null);
				 if(doctor == null) throw new ApplicationContextException("ce docteur n'existe pas");

				// City city  = cityRepo.findById(appointemetDto.getCityId()).orElse(null);
		        // if(patient == null) throw new ApplicationContextException("cette la ville n'existe pas");

				// Municipality municipality  = municipalityRepo.findById(appointemetDto.getMunicipalityId()).orElse(null);
		        // if(patient == null) throw new ApplicationContextException("la municipalitée  n'existe pas");

				// EtablissementCategory category  = etablissementcategoryRepo.findById(appointemetDto.getcategoryId()).orElse(null);
		        // if(patient == null) throw new ApplicationContextException("la category selectionner  n'existe pas");

		        Hospital hospital = hospitalRepo.findById(appointemetDto.getHospitalId()).orElse(null);
				if(hospital == null) throw new ApplicationContextException("l'hopital selectionner n'existe pas");

		        Speciality speciality = specialityRepo.findById(appointemetDto.getSpecialityId()).orElse(null);
				if(speciality == null) throw new ApplicationContextException(" la specialitée selectionnée n'existe pas");

		        Appointements appByDate = appoRepo.findAllByDate(appointemetDto.getDate());
		        if(appByDate != null) throw new ApplicationContextException("Cette date est deja occupée par un autre rdv !");


				// creation d'un rdv
		        Appointements addAppointment = new Appointements();

				// addAppointment.setcity(city);
				// addAppointment.setmunicipality(municipality);
				// addAppointment.setcategory(category);
				// addAppointment.setspeciality(speciality);
		        addAppointment.setHospital(hospital);
		        addAppointment.setPatient(patient);
		        addAppointment.setDate(appointemetDto.getDate());
				
				// ajoute un status
				// addAppointment.setStatusAppointements(StatusAppointements.PENDING);
		        appoRepo.save(addAppointment);

				//choisir un hopital et une specialisation
		        SpecialityHospitalDoctor specialityHospitalDoctor = new SpecialityHospitalDoctor();
		        specialityHospitalDoctor.setHospital(hospital);
		        specialityHospitalDoctor.setSpeciality(speciality);
				specialityHospitalDoctor.setDoctor(doctor);
		        shRepo.save(specialityHospitalDoctor);

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
	@Override
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

	//recherche par patient
	@Override
	public List<Appointements> getbyNameInAppointements(Patient patient) {
		
		return appoRepo.findAllByPatient(patient);
		}



	//recherche par patient et hospital
	//@Override
	//public List<Appointements> getbyPatientAndHospital(AppointementDto appointementDto) {

	// 	return appoRepo.findAllByPatientAndHospital(appointementDto);
		
	// 	}


	//recherche selon le doctor
	@Override
	public List<Appointements> getbyHospital(Hospital hospital) {

		return appoRepo.findAllByHospital(hospital);
		
		}
}