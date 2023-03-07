package com.example.ApiProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Users  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Le champ first_name est obligatoire")
    @NotBlank(message = "Le champ first_name ne peut etre vide")
    private String first_name;

    @NotNull(message = "Le champ last_name est obligatoire")
    @NotBlank(message = "Le champ last_name ne peut etre vide")
    private String last_name;

    @NotNull(message = "Le champ adresse est obligatoire")
    @NotBlank(message = "Le champ adresse ne peut etre vide")
    @Column(nullable = false, length = 200)
    private String adresse;

    @Column(length = 200)
    private String phone_number;

    private String login;

    private String mdPasse;

    /*
    @Column(name = "create_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "update_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    */

    @ManyToOne()
    @JoinColumn(name = " role_id")
    private Roles roles ;

}
