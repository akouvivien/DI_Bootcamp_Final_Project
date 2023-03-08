package com.example.ApiProject.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SpecialityHospitalDto {

    private Long id;

    private Long hospitalId;

    private Long doctorId;

    private Long specialityId;

}
