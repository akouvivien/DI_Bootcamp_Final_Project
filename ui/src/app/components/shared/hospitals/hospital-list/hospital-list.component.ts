import { Component, Input } from '@angular/core';
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
export class HospitalListComponent {

  //recois la list des hopitaux
  @Input() hospitalList!:Hospital[];

  //recois la  des categories
  @Input() categoryList!:Category[];

  //recois la  des municipalités
  @Input()  municipalityList!:Municipality[];


  // hopitalToupdate : Hospital = {
  //   id:,

  //   name :"" ,

  //   adresse:"",

  //   status:,

  //   municipalityId:,

  //   etablissementCategoryId:
  // }

  // constructor(

  //   private fb:FormBuilder,
  //   private _service : HospitalService

  //   ) { }

  //  //formulaire
  //  hospitalForm!: FormGroup;

  //  edit(items : any){
  //   this.hopitalToupdate=items;
  //  }

  //  updateHospital(){

  //   this._service.updateHospital(this.hopitalToupdate).subscribe({
  
  //     next: (response: any)=>{
  
  //       console.log(response)
  
  //   },
  //       error: error => {
  
  //         console.error("Erreur lors de la recuperation des des informations !", error);
  
  //       }
  //     })
  
  // }

}
