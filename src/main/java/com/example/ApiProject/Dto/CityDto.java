package com.example.ApiProject.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CityDto {

    private Long id;

    private String name;

    private Long MunicipalitiesID ;
}
