package com.example.ApiProject.Model;

import lombok.*;
import javax.persistence.*;

import com.example.ApiProject.Enums.StatusAppointements;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Appointements implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
    private Long id;

    @Column(columnDefinition="timestamp")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Patient patient;

    // @Enumerated(EnumType.STRING)
    // @Column(name = "status", columnDefinition = "VARCHAR")
    // private StatusAppointements statusAppointements;
    
  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Hospital hospital;

    @Column(name = "update_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createAt;

    @Column(name = "update_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updatedAt;

    // public Appointements(StatusAppointements statusAppointements) {
    //     this.statusAppointements = statusAppointements;
    // }
}
