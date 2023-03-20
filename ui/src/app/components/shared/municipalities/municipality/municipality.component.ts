import { Component, EventEmitter, Output } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { environnement } from 'src/app/environnements/environnement';
import { City } from 'src/app/interfaces/city';
import { Municipality } from 'src/app/interfaces/municipality';
import { User } from 'src/app/interfaces/user';
import { CityService } from 'src/app/services/api/city.api.service';
import { MunicipalityService } from 'src/app/services/api/municipality.service';

@Component({
  selector: 'app-municipality',
  templateUrl: './municipality.component.html',
  styleUrls: ['./municipality.component.css']
})
export class MunicipalityComponent {

      // la liste des villes
      cityList: any = [];
      //L'event qui sera retourné au parent et informera sur l'etat de la liste des villes
      @Output() cityListOutput: EventEmitter<any> = new EventEmitter<any>();

      //liste des communes
      municipalityList: any = [];
      //L'event qui sera retourné au parent et informera sur l'etat de la liste des pays
      @Output() municipalityListOutput: EventEmitter<any> = new EventEmitter<any>();

user!:User

      //formulaire
      municipality!: FormGroup;

     constructor(

       private _municipality : MunicipalityService ,
       private _city: CityService,
       private fb:FormBuilder,
       private route : Router) {  }


     ngOnInit(): void {

      let json = localStorage.getItem(environnement.APIKEY);
      if (json != null) {
        this.user= JSON.parse(json) as User;
        console.log(this.user.roles.name)
      }
     //actualisation du villes
       this.getallcities();
       //actualisation des pays
       this.getallMunicipality()
       
       

     //add City
         this.municipality= this.fb.group({

          name : [``,Validators.required],

          cityId : [``,Validators.required]

         });
     }

     getallcities(){

          //recuperation de la liste des villes

     this._city.getcities().subscribe({
       next: (response: any)=>{

         this.cityList = response ;

         console.log(this.cityList)

         this.cityListOutput.emit(this.cityList);


     },
         error: error => {
           console.error("Erreur lors de la recuperation des des informations de la municipalité !", error);
         }
       })

   }

   // insertion des municipalités dans la bd
   onSubmit(){
     this._municipality.createMunicipality(this.municipality.value).subscribe({
       next:(response :any) =>{
         this.getallMunicipality();
         this.municipality.reset();
       },
       error: error => {
         console.error("Erreur lors de l'enregistrement d'une nouvelle municipalité!", error);
       }
     })

   console.log(this.municipality.value)

   }


   //**********   municipality           ******* */


  //recuperation de la liste des city
  getallMunicipality(){

    this._municipality.getMunicipalies().subscribe({

      next: (response: any)=>{

        // affecte a municipalityList la liste des municipalité venu de l'api
        this.municipalityList = response ;

        // affiche  dans la console la liste des municipallité
        console.log(this.municipalityList)

        //Renvoi de la liste au composant enfant
        this.municipalityListOutput.emit(this.municipalityList);


    },
        error: error => {
          console.error("Erreur lors de la recuperation des des informations  de la municipalité!", error);
        }
      })

  }

}
