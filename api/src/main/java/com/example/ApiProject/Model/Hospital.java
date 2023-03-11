package com.example.ApiProject.Model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hospitals")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Hospital implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Le champ name de l'hopital est obligatoire")
    @NotBlank(message = "Le champ name de l'hopital ne peut etre vide")
    private String name;

    private String adresse;
    private boolean status;

    @JsonIdentityReference(alwaysAsId = false)
    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private List<Appointements> appointemnts;

    // relation a revoir
    @JsonIdentityReference(alwaysAsId = false)
    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private List<SpecialityHospitalDoctor> specialityhospital;

    @ManyToOne()
    @JoinColumn(name = "municipality_id")
    private Municipality municipality ;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private EtablissementCategory etablissementCategory ;

    @Column(name = "create_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "update_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;



}
