package com.example.ApiProject.Dto;

import com.example.ApiProject.model.Hospital;
import com.example.ApiProject.model.Speciality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SpecialityHospitalDto {

    private Long id;

    private Hospital hospitalId;

    private Speciality specialityId;

}
