import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Doctor } from 'src/app/interfaces/doctor';
import { DoctorService } from 'src/app/services/api/doctor.service';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  // la liste des doctors
  doctorList:Doctor[] = [];


   //L'event qui sera retourné au parent et informera sur l'etat de la liste des doctors
   @Output() doctorListOutput: EventEmitter<Doctor[]> = new EventEmitter<Doctor[]>();


   //formulaire
  doctorForm!: FormGroup;

  constructor(private _doctor : DoctorService ,
    private fb:FormBuilder,
    private route : Router) {  }


  ngOnInit(): void {
  //actualisation du docteur
    this.getalldoctors();

  //add doctor
      this.doctorForm= this.fb.group({

        email : [``,Validators.required,],

        password : [``,Validators.required],

        first_name : [``,Validators.required],

        last_name : [``,Validators.required],

        phone_number : '',

        login : [``,Validators.required ],

        address : [``,Validators.required],

        matricule: [``,Validators.required]

      });
  }

getalldoctors(){

       //recuperation de la liste des doctors

  this._doctor.getDoctors().subscribe({
    next: (response: any)=>{

      // affecte a doctorist la liste des docteurs venu de l'api
      this.doctorList = response as Doctor[];

      // affiche  dans la console la liste des doctors
      console.log(this.doctorList)

      //Renvoi de la liste au composant enfant
      this.doctorListOutput.emit(this.doctorList);


  },
      error: error => {
        console.error("Erreur lors de la recuperation des des informations !", error);
      }
    })

}




onSubmit(){
  this._doctor.createDoctor(this.doctorForm.value).subscribe({
    next:(response :any) =>{
      this.getalldoctors();
    },
    error: error => {
      console.error("Erreur lors de l'enregistrement d'un nouveau doctor!", error);
    }
  })

console.log(this.doctorForm.value)

}

}
