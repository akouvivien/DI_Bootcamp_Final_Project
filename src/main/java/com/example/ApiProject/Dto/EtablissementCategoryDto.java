package com.example.ApiProject.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EtablissementCategoryDto {

    private Long id;

    private String category;

    private Long hospitalsId ;
}
