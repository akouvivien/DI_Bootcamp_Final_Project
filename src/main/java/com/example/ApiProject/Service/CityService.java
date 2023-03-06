package com.example.ApiProject.Service;

import com.example.ApiProject.Dto.CityDto;
import com.example.ApiProject.model.City;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CityService {

    City createCity(CityDto cityDto);

    City updateCity (Long id, CityDto cityDto);

    void deleteCityId(Long id);

    Optional<City> getCityId(Long id);

    List<City> getCities();

    void deleteCities();
}
