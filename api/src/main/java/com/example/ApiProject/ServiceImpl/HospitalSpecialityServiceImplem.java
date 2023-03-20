package com.example.ApiProject.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApiProject.Model.Hospital;
import com.example.ApiProject.Model.HospitalSpeciality;
import com.example.ApiProject.Model.Speciality;
import com.example.ApiProject.Repository.HospitalSpecialityRepository;
import com.example.ApiProject.Service.HospitalSpecialityService;

@Service
public class HospitalSpecialityServiceImplem implements HospitalSpecialityService {

    @Autowired
    HospitalSpecialityRepository hospitalspe;

    @Override
    public HospitalSpeciality createHospitalSpeciality(HospitalSpeciality hospitalspeciality) {
    
        return hospitalspe.save(hospitalspeciality);

    }

    @Override
    public List<HospitalSpeciality> getHospitalSpeciality() {
   
        return  hospitalspe.findAll();
   
    }

    @Override
    public Optional<HospitalSpeciality> getHospitalSpecialityId(Long id) {

        return  hospitalspe.findById(id);
    }

    @Override
    public void DeleteHospitalSpecialityId(Long id) {
      
        hospitalspe.deleteById(id);
    
    }

    @Override
    public void deleteHospitalSpeciality() {
         
          hospitalspe.deleteAll();

    }

    @Override
    public HospitalSpeciality updateHospitalSpeciality(Long id, HospitalSpeciality hospitalspeciality) {

        HospitalSpeciality hs = hospitalspe.findById(id).orElse(null);

		if(hs !=null){

			BeanUtils.copyProperties(hospitalspe, hs, "id");

			hospitalspe.save(hs);
		}
		return hospitalspe.save(hs);

    }
    @Override
    public List<HospitalSpeciality> getbyspecialities(Speciality speciality) {
        
        return hospitalspe.findAllBySpeciality(speciality);
    }

    @Override
    public List<HospitalSpeciality> getbyHospitals(Hospital hospital) {
       
        return  hospitalspe.findAllByHospital(hospital);
    }
    
}
