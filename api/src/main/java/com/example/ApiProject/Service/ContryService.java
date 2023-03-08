package com.example.ApiProject.Service;

import com.example.ApiProject.Dto.CityDto;
import com.example.ApiProject.Dto.ContryDto;
import com.example.ApiProject.model.Contry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ContryService {

    Contry createContry(ContryDto contryDto);

    Contry updateContry (Long id, ContryDto contryDto);

    void deleteContryId(Long id);

    Optional<Contry> getContryId(Long id);

    List<Contry> getContries();

    void deleteContries();
}
