package com.example.ApiProject.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    private Long id;

    private String first_name;

    private String last_name;

    private String adresse;


    private String email;

    private String phone_number;

    private boolean doctor_status;

    private Long specialityId;
}
