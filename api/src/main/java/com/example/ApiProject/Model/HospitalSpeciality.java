package com.example.ApiProject.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class HospitalSpeciality implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;
  
    @ManyToOne()
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @Column(name = "create_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createAt;

    @Column(name = "update_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updatedAt;
    
}
