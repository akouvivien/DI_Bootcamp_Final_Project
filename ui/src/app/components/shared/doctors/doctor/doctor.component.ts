import { User } from 'src/app/interfaces/user';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { environnement } from 'src/app/environnements/environnement';
import { Speciality } from 'src/app/interfaces/speciality';
import { DoctorService } from 'src/app/services/api/doctor.service';
import { SpecialityService } from 'src/app/services/api/speciality.service';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  user!:User
  // la liste des doctors
  doctorList: any = [];


   //L'event qui sera retourné au parent et informera sur l'etat de la liste des doctors
   @Output() doctorListOutput: EventEmitter<any> = new EventEmitter<any>();


   specialityList : Speciality[]= []

    //L'event qui sera retourné au parent et informera sur l'etat de la liste des specialités
   @Output() specialityListOutput: EventEmitter<Speciality[]> = new EventEmitter<Speciality[]>();


   //formulaire
  doctorForm!: FormGroup;

  constructor(private _doctor : DoctorService ,
    private _speciality : SpecialityService,
    private fb:FormBuilder,
    private route : Router) {  }


  ngOnInit(): void {
  //actualisation du docteur
    this.getalldoctors();
    this.getALLSpecialitys()

    let json = localStorage.getItem(environnement.APIKEY);
    if (json != null) {
      this.user = JSON.parse(json) as User;
      console.log("local storage")
      console.log(this.user)

      }

  //add doctor
      this.doctorForm= this.fb.group({

        email : [``,Validators.required,],

        password : [``,Validators.required],

        first_name : [``,Validators.required],

        last_name : [``,Validators.required],

        phone_number : '',

        login : [``,Validators.required ],

        address : [``,Validators.required],

        matricule: [``,Validators.required],

        speciality: [``,Validators.required]

      });
  }

getalldoctors(){

       //recuperation de la liste des doctors

  this._doctor.getDoctors().subscribe({
    next: (response: any)=>{

      // affecte a doctorist la liste des docteurs venu de l'api
      this.doctorList = response ;

      // affiche  dans la console la liste des doctors

      console.log("la liste des doctors envoyer")
      console.log(this.doctorList)

      //Renvoi de la liste au composant enfant
      this.doctorListOutput.emit(this.doctorList);


  },
      error: error => {
        console.error("Erreur lors de la recuperation des des informations !", error);
      }
    })

}
// **************liste des specialités*******************


getALLSpecialitys(){

  this._speciality.getSpeciality().subscribe({

    next: (response: any)=>{

      // affecte a specialityList la liste des speciality venu de l'api
      this.specialityList = response as Speciality[];

      // affiche  dans la console la liste des speciality

      console.log("la liste des specialité disponible dans le systeme doctor")
      console.log(this.specialityList)

      //Renvoi de la liste au composant enfant
      this.specialityListOutput.emit(this.specialityList);


  },
      error: error => {
        console.error("Erreur lors de la recuperation des ,specialités!", error);
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
 window.location.reload()

}

}
