package com.example.ApiProject.Model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "doctors")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Doctor extends Users implements Serializable {


    @NotNull(message = "Le matricule du medecin est obligatoire")
    @NotBlank(message = "Le matricule ne peut etre vide")
    @Column(unique = true)
    private String matricule ;

    // relation hopital, docteur et specialité
    // @JsonIdentityReference(alwaysAsId = false)
    // @OneToMany( mappedBy = "doctor", cascade = CascadeType.ALL)
    // @JsonIgnore
    // private List<SpecialityHospitalDoctor> specialityhospital;

    // relation hopital et docteur
    // @JsonIdentityReference(alwaysAsId = false)
    // @OneToMany( mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // @JsonIgnore
    // private List<HospitalDoctor> hospitaldoctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speciality_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Speciality speciality;
}
