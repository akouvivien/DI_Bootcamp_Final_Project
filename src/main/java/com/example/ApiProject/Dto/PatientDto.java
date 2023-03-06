package com.example.ApiProject.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PatientDto {
    private Long id;

    private String first_name;

    private String last_name;

    private Date Birthday;

    private String address;

    private String phone_number;
}
