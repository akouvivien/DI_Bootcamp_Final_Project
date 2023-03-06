package com.example.ApiProject.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "doctors")
public class Doctor  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Le champ first_name est obligatoire")
    @NotBlank(message = "Le champ first_name ne peut etre vide")
    @Column(length = 100)
    private String first_name;

    @NotNull(message = "Le champ last_name est obligatoire")
    @NotBlank(message = "Le champ last_name ne peut etre vide")
    @Column(length = 100)
    private String last_name;

    @NotNull(message = "Le champ adresse est obligatoire")
    @NotBlank(message = "Le champ adresse ne peut etre vide")
    @Column(nullable = false, length = 200)
    private String adresse;

    @Email
    private String email;
    
    private String phone_number;

    private boolean doctor_status;
    
    @ManyToOne()
    @JoinColumn(name = " speciality_id")
    private Speciality speciality;
}
