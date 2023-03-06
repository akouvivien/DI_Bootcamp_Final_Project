package com.example.ApiProject.model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class Patient  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
   
    @NotNull(message = "Le champ first_name est obligatoire")
    @NotBlank(message = "Le champ first_name ne peut etre vide")
    @Column(length = 100)
    private String first_name;

    @NotNull(message = "Le champ last_name est obligatoire")
    @NotBlank(message = "Le champ last_name ne peut etre vide")
    @Column(length = 200)
    private String last_name;

    @Temporal(TemporalType.DATE)
    private Date Birthday;

    @NotNull(message = "Le champ adresse est obligatoire")
    @NotBlank(message = "Le champ adresse ne peut etre vide")
    @Column(nullable = false, length = 200)
    private String adresse;

    @Column(length = 200)
    private String phone_number;

//    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
//    private Collection<Appointements> appointemnts;

}
