import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Category } from 'src/app/interfaces/category';
import { Hospital } from 'src/app/interfaces/hospital';
import { Municipality } from 'src/app/interfaces/municipality';
import { HospitalService } from 'src/app/services/api/hospital.service';

@Component({
  selector: 'app-hospital-list',
  templateUrl: './hospital-list.component.html',
  styleUrls: ['./hospital-list.component.css']
})
export class HospitalListComponent implements OnInit {

  //recois la list des hopitaux
  hospitalList : any = [];

  //recois la  des categories
  @Input() categoryList!:Category[];

  //recois la  des municipalités
  @Input()  municipalityList!:Municipality[];


  constructor(

    private fb:FormBuilder,
    private _service : HospitalService

    ) { }
  ngOnInit(): void {
    this.getallHospitals();
  }


    //recuperation de la liste des hopitaux
getallHospitals(){

  this._service.getHospitals().subscribe({

    next: (response: any)=>{

      // affecte a doctorist la liste des Hopitaux venu de l'api
      this.hospitalList = response;

      // affiche  dans la console la liste des hopitaux
      console.log("les hopitaux")
      console.log(this.hospitalList)

      //Renvoi de la liste au composant enfant
      // this.hospitalListOutput.emit(this.hospitalList);

  },
      error: error => {

        console.error("Erreur lors de la recuperation des des informations !", error);

      }
    })

}



}
