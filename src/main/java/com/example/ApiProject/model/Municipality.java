package com.example.ApiProject.model;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "municipalities")
public class Municipality implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Le champ name de la municipalité est obligatoire")
    @NotBlank(message = "Le champ name de la municipalité ne peut etre vide")
    @Column(length = 100)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_muni_id",referencedColumnName ="id")
    private List<Hospital> hospitals ;
}
