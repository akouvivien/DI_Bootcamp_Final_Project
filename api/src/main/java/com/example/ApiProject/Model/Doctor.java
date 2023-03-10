package com.example.ApiProject.Model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "doctors")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Doctor extends Users implements Serializable {

 private String Matricule ;

 private boolean doctor_status;

    @Column(name = "create_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "update_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // a revoir la relation
    @JsonIdentityReference(alwaysAsId = false)
    @OneToMany( mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<SpecialityHospital> specialityhospital;
}
