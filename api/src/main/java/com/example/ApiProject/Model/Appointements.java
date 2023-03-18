package com.example.ApiProject.Model;

import lombok.*;
import javax.persistence.*;

import com.example.ApiProject.Enums.StatusAppointements;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Appointements implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
    private Long id;

    @Column(columnDefinition="timestamp")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "VARCHAR")
    private StatusAppointements statusAppointements;
    
  
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @Column(name = "update_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createAt;

    @Column(name = "update_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updatedAt;

    public Appointements(StatusAppointements statusAppointements) {
        this.statusAppointements = statusAppointements;
    }
}
