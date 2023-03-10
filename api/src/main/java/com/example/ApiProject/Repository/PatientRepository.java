package com.example.ApiProject.Repository;

import com.example.ApiProject.Model.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

//list des patients  par hopital dont le rdv est en attente selon la date
// @Query( "SELECT p FROM Patient p JOIN  p.appointements a JOIN a.hospital h  WHERE h.name =:hospitalName and a.date=:dateRdv and a.statusappointements= ' PENDING'")
// List<Patient> findPatientsByHospitalAndPendingAppointements(@Param ("hospitalName") String hospitalName, @Param ("dateRdv") String dateRdv);

// //list des patients  par hopital dont le rdv est en Annulé selon la date
// @Query( "SELECT p FROM Patient p JOIN  p.appointements a JOIN a.hospital h  WHERE h.name =:hospitalName and a.date=:dateRdv and a.statusappointements= ' ANNULE' ")
// List<Patient> findPatientsByHospitalAndAnnuleAppointements(@Param ("hospitalName") String hospitalName, @Param ("dateRdv") String dateRdv);


// //list des patients  par hopital dont le rdv est  Validé selon la date
// @Query( "SELECT p FROM Patient p JOIN  p.appointements a JOIN a.hospital h  WHERE h.name =:hospitalName and a.date=:dateRdv and a.statusappointements= ' ANNULE'")
// List<Patient> findPatientsByHospitalAndValideAppointements(@Param ("hospitalName") String hospitalName, @Param ("dateRdv") String dateRdv);

//la liste des patients par hopital selon ma date de rdv et le status souhaité 
// @Query( "SELECT p FROM Patient p JOIN  p.appointements a JOIN a.hospital h  WHERE h.name =:hospitalName and a.date=:dateRdv and a.statusappointements=: 'status' ")
// List<Patient> findPatientsByHospitalAndPendingAppointements(@Param ("hospitalName") String hospitalName, @Param ("dateRdv") String dateRdv,@Param ("status") String status);

}
