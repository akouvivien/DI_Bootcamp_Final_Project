import { HospitalService } from './../../../../services/api/hospital.service';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Hospital } from 'src/app/interfaces/hospital';

@Component({
  selector: 'app-hospital',
  templateUrl: './hospital.component.html',
  styleUrls: ['./hospital.component.css']
})
export class HospitalComponent {

   // la liste des doctors
   hospitalList:Hospital[] = [];


   //L'event qui sera retourné au parent et informera sur l'etat de la liste des hopitaux
   @Output() hospitalListOutput: EventEmitter<Hospital[]> = new EventEmitter<Hospital[]>();


   //formulaire
   hospitalForm!: FormGroup;

  constructor(private _hospital : HospitalService ,
    private fb:FormBuilder,
    private route : Router) {  }


  ngOnInit(): void {
  //actualisation du tableau des hopitaux
    this.getallHospitals();

  //add doctor
      this.hospitalForm= this.fb.group({

        name :  [``,Validators.required,],

        adresse:[``,Validators.required],
        
        status:"",
        
        municipalityId:[``,Validators.required],
        
        etablissementCategoryId:[``,Validators.required],


      });
  }


  
//recuperation de la liste des doctors
getallHospitals(){


  this._hospital.getHospitals().subscribe({
    next: (response: any)=>{

      // affecte a doctorist la liste des Hopitaux venu de l'api
      this.hospitalList = response as Hospital[];

      // affiche  dans la console la liste des hopitaux
      console.log(this.hospitalList)

      //Renvoi de la liste au composant enfant
      this.hospitalListOutput.emit(this.hospitalList);


  },
      error: error => {
        console.error("Erreur lors de la recuperation des des informations !", error);
      }
    })

}



//enregistrement d'un nouvel hopital
onSubmit(){
  this._hospital.createHospital(this.hospitalForm.value).subscribe({
    next:(response :any) =>{
      this.getallHospitals();
    },
    error: error => {
      console.error("Erreur lors de l'enregistrement d'un nouveau doctor!", error);
    }
  })

console.log(this.hospitalForm.value)

}

//TODO a emit la liste des municipalités
//recuperation de la liste des municipalités
getallMunicipality(){


  this._hospital.getHospitals().subscribe({
    next: (response: any)=>{

      // affecte a doctorist la liste des Hopitaux venu de l'api
      this.hospitalList = response as Hospital[];

      // affiche  dans la console la liste des hopitaux
      console.log(this.hospitalList)

      //Renvoi de la liste au composant enfant
      this.hospitalListOutput.emit(this.hospitalList);


  },
      error: error => {
        console.error("Erreur lors de la recuperation des des informations !", error);
      }
    })

}

//TODO a emit la liste des categories
//recuperation de la liste des categories d'hopitaux
getallCategory(){


  this._hospital.getHospitals().subscribe({
    next: (response: any)=>{

      // affecte a doctorist la liste des Hopitaux venu de l'api
      this.hospitalList = response as Hospital[];

      // affiche  dans la console la liste des hopitaux
      console.log(this.hospitalList)

      //Renvoi de la liste au composant enfant
      this.hospitalListOutput.emit(this.hospitalList);


  },
      error: error => {
        console.error("Erreur lors de la recuperation des des informations !", error);
      }
    })

}


}
