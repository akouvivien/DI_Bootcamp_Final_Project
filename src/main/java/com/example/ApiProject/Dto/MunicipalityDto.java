package com.example.ApiProject.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MunicipalityDto {

    private Long id;

    private String name;

    private Long  hospitalsId ;
}
