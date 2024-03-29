package com.example.ApiProject.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "specialities")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Speciality   implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)  
    @NotNull(message = "Le champ name de la specialité est obligatoire")
    @NotBlank(message = "Le champ name de la specialité ne peut etre vide")
    private String name;

    // @JsonIdentityReference(alwaysAsId = false)
    // @OneToMany( mappedBy = "speciality",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // @JsonIgnore
    // private List<SpecialityHospitalDoctor> specialityhospital;

    // @JsonIdentityReference(alwaysAsId = false)
    // @OneToMany(mappedBy = "speciality",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    // @JsonIgnore
    // private List<HospitalSpeciality> hospitalspeciality;

    // @JsonIdentityReference(alwaysAsId = false)
    // @OneToMany( mappedBy = "speciality",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // @JsonIgnore
    // private List<Doctor> doctor;

    @Column(name = "create_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createAt;

    @Column(name = "update_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updatedAt;

}
