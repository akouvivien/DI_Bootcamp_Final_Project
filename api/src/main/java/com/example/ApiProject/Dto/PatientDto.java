package com.example.ApiProject.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PatientDto {
    private Long id;

    private String first_name;

    private String last_name;

    private String address;

    private String login;

    private String password;

    private String email;

    private String phone_number;
}
