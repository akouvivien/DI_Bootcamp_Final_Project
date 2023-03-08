package com.example.ApiProject.Model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Patient extends Users  implements Serializable {
    
   /* @Id
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
    private String phone_number;*/

   @JsonIdentityReference(alwaysAsId = false)

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)

   private List<Appointements> appointemnts;

    @Column(name = "create_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)

    @Temporal(TemporalType.TIMESTAMP)

    private Date createAt;

    @Column(name = "update_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)

    @Temporal(TemporalType.TIMESTAMP)

    private Date updatedAt;

}
