package com.example.ApiProject.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class DoctorDto {

    private Long id;

    private String first_name;

    private String last_name;

    private String adresse;

    private String email;

    private String phone_number;

    private String login;

    private String mdPasse;

    //private  Long roleId;

    private boolean doctor_status;

    private String Matricule;

}