import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Contry } from 'src/app/interfaces/contry';
import { ContryService } from 'src/app/services/api/contry.service';

@Component({
  selector: 'app-contry',
  templateUrl: './contry.component.html',
  styleUrls: ['./contry.component.css']
})
export class ContryComponent {

    //liste des pays
    contryList:Contry[] = [];

    

    //L'event qui sera retourné au parent et informera sur l'etat de la liste des pays
    @Output() contryListOutput: EventEmitter<Contry[]> = new EventEmitter<Contry[]>();

    constructor(

      private _contry: ContryService,
      private fb:FormBuilder,
      private route : Router) {  }


    //formulaire
    contryForm!: FormGroup;

   ngOnInit(): void {
   //actualisation du docteur
     this.getallContries();

   //add doctor
       this.contryForm= this.fb.group({

        name : [``,Validators.required]

       });
   }

    // insertion des villes dans la bd
 onSubmit(){
  this._contry.createContry(this.contryForm.value).subscribe({
    next:(response :any) =>{
      this.getallContries();
    },
    error: error => {
      console.error("Erreur lors de l'enregistrement d'une nouvelle ville!", error);
    }
  })

console.log(this.contryForm.value)

}



   getallContries(){

      this._contry.getContries().subscribe({

        next: (response: any)=>{

          // affecte a contryList la liste des Hopitaux venu de l'api
          this.contryList = response as Contry[];

          // affiche  dans la console la liste des contry
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
