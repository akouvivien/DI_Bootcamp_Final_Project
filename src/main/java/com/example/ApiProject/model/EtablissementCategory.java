package com.example.ApiProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "EtablissementCategories")
public class EtablissementCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Le champ categorie est obligatoire")
    @NotBlank(message = "Le champ categorie ne peut etre vide")
    @Column(length = 100)
    private String category;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cat_id",referencedColumnName ="id")
    private List<Hospital> hospitals ;
}
