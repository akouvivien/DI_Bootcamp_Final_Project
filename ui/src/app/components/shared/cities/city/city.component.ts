import { Component, EventEmitter, Output } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { City } from 'src/app/interfaces/city';
import { Contry } from 'src/app/interfaces/contry';
import { Doctor } from 'src/app/interfaces/doctor';
import { CityService } from 'src/app/services/api/city.api.service';
import { ContryService } from 'src/app/services/api/contry.service';

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent {

    // la liste des villes
    cityList:City[] = [];
    //L'event qui sera retourné au parent et informera sur l'etat de la liste des villes
    @Output() cityListOutput: EventEmitter<City[]> = new EventEmitter<City[]>();

    //liste des pays
    contryList:Contry[] = [];
    //L'event qui sera retourné au parent et informera sur l'etat de la liste des pays
    @Output() contryListOutput: EventEmitter<Contry[]> = new EventEmitter<Contry[]>();



    //formulaire
    cityForm!: FormGroup;

   constructor(

     private _city : CityService ,
     private _contry: ContryService,
     private fb:FormBuilder,
     private route : Router) {  }


   ngOnInit(): void {
   //actualisation du villes
     this.getallcities();
     //actualisation des pays
     this.getallContry()

   //add City
       this.cityForm= this.fb.group({

        name : [``,Validators.required],

        contryid : [``,Validators.required]

       });
   }

   getallcities(){

        //recuperation de la liste des doctors

   this._city.getcities().subscribe({
     next: (response: any)=>{

       // affecte a doctorist la liste des villes venu de l'api
       this.cityList = response as City[];

       // affiche  dans la console la liste des villes
       console.log(this.cityList)

       //Renvoi de la liste au composant enfant
       this.cityListOutput.emit(this.cityList);


   },
       error: error => {
         console.error("Erreur lors de la recuperation des des informations !", error);
       }
     })

 }

 // insertion des villes dans la bd
 onSubmit(){
   this._city.createCity(this.cityForm.value).subscribe({
     next:(response :any) =>{
       this.getallcities();
     },
     error: error => {
       console.error("Erreur lors de l'enregistrement d'une nouvelle ville!", error);
     }
   })

 console.log(this.cityForm.value)

 }


 //**********   Contry           ******* */

//TODO a emit la liste des municipalités
//recuperation de la liste des municipalités
getallContry(){

  this._contry.getContries().subscribe({

    next: (response: any)=>{

      // affecte a doctorist la liste des Hopitaux venu de l'api
      this.contryList = response as Contry[];

      // affiche  dans la console la liste des hopitaux
      console.log(this.contryList)

      //Renvoi de la liste au composant enfant
      this.contryListOutput.emit(this.contryList);


  },
      error: error => {
        console.error("Erreur lors de la recuperation des des informations  de la municipalité!", error);
      }
    })

}

}
