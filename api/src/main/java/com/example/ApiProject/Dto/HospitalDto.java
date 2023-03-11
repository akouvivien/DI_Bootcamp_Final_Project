package com.example.ApiProject.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDto {

    private Long id;

    private String name;

    private String adresse;

    private boolean status;

    private Long municipalityId;

    private Long etablissementCategoryId;
}

