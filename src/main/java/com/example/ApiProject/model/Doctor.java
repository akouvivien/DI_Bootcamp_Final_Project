package com.example.ApiProject.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "doctors")
public class Doctor extends Users implements Serializable {

   /*@Id
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


    /*
    @ManyToOne()
    @JoinColumn(name = " speciality_id")
    private SpecialityHospital specialityHospital;

     */
 private String Matricule ;
 private boolean doctor_status;

    @Column(name = "create_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "update_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}
