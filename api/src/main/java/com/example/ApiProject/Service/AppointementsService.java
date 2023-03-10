package com.example.ApiProject.Service;

import com.example.ApiProject.Dto.AppointementDto;
import com.example.ApiProject.Model.Appointements;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AppointementsService {

    Appointements createAppointement(AppointementDto appointementDto);

    List<Appointements> getAppointements();
    

    Optional<Appointements> getAppointementId(Long id);

    void DeleteAppointementId(Long id);

    void deleteAppointements();

    Appointements updateAppointement(Long id, AppointementDto appointementdto);

}
