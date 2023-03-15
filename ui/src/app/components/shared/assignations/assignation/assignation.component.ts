import { Assignements } from 'src/app/interfaces/assignements';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Doctor } from 'src/app/interfaces/doctor';
import { Hospital } from 'src/app/interfaces/hospital';
import { Speciality } from 'src/app/interfaces/speciality';
import { AssignementService } from 'src/app/services/api/assignements.service';
import { DoctorService } from 'src/app/services/api/doctor.service';
import { HospitalService } from 'src/app/services/api/hospital.service';
import { SpecialityService } from 'src/app/services/api/speciality.service';

@Component({
  selector: 'app-assignation',
  templateUrl: './assignation.component.html',
  styleUrls: ['./assignation.component.css']
})
export class AssignationComponent {



    //liste des affectations
    assignementlList:Assignements[] = [];

    //L'event qui sera retourné au parent et informera sur l'etat de la liste des affectations
    @Output() assignementlListOutput: EventEmitter<Assignements[]> = new EventEmitter<Assignements[]>();

    //liste des hopitaux
    hospitalList:Hospital[] = [];

    //L'event qui sera retourné au parent et informera sur l'etat de la liste des category
    @Output() hospitalListOutput: EventEmitter<Hospital[]> = new EventEmitter<Hospital[]>();

    //liste des specialités
    specialityList:Speciality[] = [];

    //L'event qui sera retourné au parent et informera sur l'etat de la liste des Patients
    @Output() specialityListOutput: EventEmitter<Speciality[]> = new EventEmitter<Speciality[]>();


    //liste des doctors
    doctorList:Doctor[] = [];

    //L'event qui sera retourné au parent et informera sur l'etat de la liste des Patients
    @Output() doctorListOutput: EventEmitter<Doctor[]> = new EventEmitter<Doctor[]>();



    constructor(
      private _hospital: HospitalService,
      private _speciality :  SpecialityService,
      private _doctor : DoctorService,
      private _assign : AssignementService,
      private fb:FormBuilder,
      private route : Router
      // , private modalService: NgbModal
      ) {  }


    //formulaire
    assignementForm!: FormGroup;

   ngOnInit(): void {

   //actualisation
     this.getallAssignements();
     this.getALLHospitals(),
     this.getALLSpecialitys(),

   //add appointements
       this.assignementForm= this.fb.group({

        hospitalId : [``,Validators.required],

        doctorId :[``,Validators.required],

        specialityId : [``,Validators.required]

       });
   }

    // effectuer des assignements dans la bd
 onSubmit(){
  this._assign.createAssign(this.assignementForm.value).subscribe({
    next:(response :any) =>{
      this.getallAssignements();
    },
    error: error => {
      console.error("Erreur lors de l'enregistrement des assignements!", error);
    }
  })

console.log(this.assignementForm.value)

}



getallAssignements(){

      this._assign.getAssigns().subscribe({

        next: (response: any)=>{

          // affecte a assignementlList la liste des assignements venue de l'api
          this.assignementlList = response as Assignements[];

          // affiche  dans la console la liste des assignement
          console.log(this.assignementlList)

          //Renvoi de la liste au composant enfant
          this.assignementlListOutput.emit(this.assignementlList);


      },
          error: error => {
            console.error("Erreur lors de la recuperation des des informations des rendez vous!", error);
          }
        })



}
//***************hospital**************** */

getALLHospitals(){

  this._hospital.getHospitals().subscribe({

    next: (response: any)=>{

      // affecte a HospitalList la liste des appointement venu de l'api
      this.hospitalList = response as Hospital[];

      // affiche  dans la console la liste des appointement
      console.log(this.hospitalList)

      //Renvoi de la liste au composant enfant
      this.hospitalListOutput.emit(this.hospitalList);


  },
      error: error => {
        console.error("Erreur lors de la recuperation des hopitaux!", error);
      }
    })

}


//***************speciality**************** */

getALLSpecialitys(){

  this._speciality.getSpeciality().subscribe({

    next: (response: any)=>{

      // affecte a specialityList la liste des speciality venu de l'api
      this.specialityList = response as Speciality[];

      // affiche  dans la console la liste des speciality
      console.log(this.specialityList)

      //Renvoi de la liste au composant enfant
      this.specialityListOutput.emit(this.specialityList);


  },
      error: error => {
        console.error("Erreur lors de la recuperation des ,specialités!", error);
      }
    })

}

}
