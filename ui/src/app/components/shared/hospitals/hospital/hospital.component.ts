import { HospitalService } from './../../../../services/api/hospital.service';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Category } from 'src/app/interfaces/category';
import { Hospital } from 'src/app/interfaces/hospital';
import { Municipality } from 'src/app/interfaces/municipality';
import { CategoryService } from 'src/app/services/api/category.service';
import { MunicipalityService } from 'src/app/services/api/municipality.service';

@Component({
  selector: 'app-hospital',
  templateUrl: './hospital.component.html',
  styleUrls: ['./hospital.component.css']
})
export class HospitalComponent {

        // la liste des hopitaux
        hospitalList: any = [];

        //L'event qui sera retourné au parent et informera sur l'etat de la liste des hopitaux
        // @Output() hospitalListOutput: EventEmitter<any> = new EventEmitter<any>();

        //liste des categories
        categoryList:Category[] = [];

        //L'event qui sera retourné au parent et informera sur l'etat de la liste des category
        @Output() categoryListOutput: EventEmitter<Category[]> = new EventEmitter<Category[]>();

        //liste des municipalités
        municipalityList:Municipality[] = [];


        //L'event qui sera retourné au parent et informera sur l'etat de la liste des Municipalités
        @Output() municipalityListOutput: EventEmitter<Municipality[]> = new EventEmitter<Municipality[]>();



  constructor(
    private _hospital : HospitalService ,

    private _category : CategoryService,

    private _municipality : MunicipalityService,

    private fb:FormBuilder,

    private route : Router,
    ) {  }

   //formulaire
   hospitalForm!: FormGroup;

  ngOnInit(): void {
  //actualisation du tableau des hopitaux
    // this.getallHospitals();
    this.getallMunicipality();
    this.getallCategory()

  //add Hospital
      this.hospitalForm= this.fb.group({

        name :  [``,Validators.required,],

        adresse:[``,Validators.required],

        status:'',

        municipalityId:[``,Validators.required],

        etablissementCategoryId:[``,Validators.required]

      });
  }

// //recuperation de la liste des hopitaux
// getallHospitals(){

//   this._hospital.getHospitals().subscribe({

//     next: (response: any)=>{

//       // affecte a doctorist la liste des Hopitaux venu de l'api
//       this.hospitalList = response;

//       // affiche  dans la console la liste des hopitaux
//       console.log("les hopitaux")
//       console.log(this.hospitalList)

//       //Renvoi de la liste au composant enfant
//       this.hospitalListOutput.emit(this.hospitalList);

//   },
//       error: error => {

//         console.error("Erreur lors de la recuperation des des informations !", error);

//       }
//     })

// }

//enregistrement d'un nouvel hopital
onSubmit(){

  this._hospital.createHospital(this.hospitalForm.value).subscribe({

    next:(response :any) =>{

      // this.getallHospitals();

    },
    error: error => {

      console.error("Erreur lors de l'enregistrement d'un nouvel hopital!", error);

    }
  })

console.log(this.hospitalForm.value)

}

//**********   Municipality           ******* */

//TODO a emit la liste des municipalités
//recuperation de la liste des municipalités
getallMunicipality(){

  this._municipality.getMunicipalies().subscribe({

    next: (response: any)=>{

      // affecte a doctorist la liste des Hopitaux venu de l'api
      this.municipalityList = response as Municipality[];

      // affiche  dans la console la liste des hopitaux
      console.log("municipalité")
      console.log(this.municipalityList)

      //Renvoi de la liste au composant enfant
      this.municipalityListOutput.emit(this.municipalityList);


  },
      error: error => {
        console.error("Erreur lors de la recuperation des des informations  de la municipalité!", error);
      }
    })

}


//********************* categories******************* */

//TODO a emit la liste des categories
//recuperation de la liste des categories d'hopitaux
getallCategory(){


  this._category.getCategorys().subscribe({

    next: (response: any)=>{

      // affecte a doctorist la liste des categories venu de l'api
      this.categoryList = response as Category[];

      // affiche  dans la console la liste des categories
      console.log(this.categoryList)

      //Renvoi de la liste au composant enfant
      this.categoryListOutput.emit(this.categoryList);

  },
      error: error => {

        console.error("Erreur lors de la recuperation des des informations de la categorie !", error);

      }
    })

}

}
