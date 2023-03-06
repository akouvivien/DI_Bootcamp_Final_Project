package com.example.ApiProject.model;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hospitals")
public class Hospital implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull(message = "Le champ name de l'hopital est obligatoire")
    @NotBlank(message = "Le champ name de l'hopital ne peut etre vide")
    private String name;

    private String adresse;
    private boolean status;

//    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
//    private Collection<Appointements> appointemnts;



}
