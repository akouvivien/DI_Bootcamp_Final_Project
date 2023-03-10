package com.example.ApiProject.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiginUpDto {

    private String email;

    private String password;

    private String first_name;

    private String last_name;


    private String phone_number;

    private String login;

    private String adresse;


    //private String  rolesId;

}
