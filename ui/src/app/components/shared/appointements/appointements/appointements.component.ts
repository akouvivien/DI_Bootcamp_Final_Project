import { Hospital } from 'src/app/interfaces/hospital';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Appointements } from 'src/app/interfaces/appointements';
import { AppointementService } from 'src/app/services/api/appointements.service';
import { Patient } from 'src/app/interfaces/patient';
import { HospitalService } from 'src/app/services/api/hospital.service';
import { PatientService } from 'src/app/services/api/patient.service';
import { Speciality } from 'src/app/interfaces/speciality';
import { SpecialityService } from 'src/app/services/api/speciality.service';
import { User } from 'src/app/interfaces/user';
import { environnement } from 'src/app/environnements/environnement';

@Component({
  selector: 'app-appointements',
  templateUrl: './appointements.component.html',
  styleUrls: ['./appointements.component.css']
})
export class AppointementsComponent {

    // recuperation  de l'utilisateur
        user!:User
    //liste des rdv
    appointementList:Appointements[] = [];

    //L'event qui sera retourné au parent et informera sur l'etat des rdv
    @Output() appointementListOutput: EventEmitter<Appointements[]> = new EventEmitter<Appointements[]>();

    //liste des hopitaux
    hospitalList:Hospital[] = [];

    //L'event qui sera retourné au parent et informera sur l'etat de la liste des category
    @Output() hospitalListOutput: EventEmitter<Hospital[]> = new EventEmitter<Hospital[]>();

    //liste des Patients
    patientsList:Patient[] = [];

    //L'event qui sera retourné au parent et informera sur l'etat de la liste des Patients
    @Output() patientsListOutput: EventEmitter<Patient[]> = new EventEmitter<Patient[]>();


    //liste des specialités
    specialityList:Speciality[] = [];

    //L'event qui sera retourné au parent et informera sur l'etat de la liste des Patients
    @Output() specialityListOutput: EventEmitter<Speciality[]> = new EventEmitter<Speciality[]>();



    constructor(

      private _appointements: AppointementService,
      private _hospital: HospitalService,
      private _patient : PatientService,
      private _speciality :  SpecialityService,
      private fb:FormBuilder,
      private route : Router
      // , private modalService: NgbModal
      ) {  }


    //formulaire
    appointementForm!: FormGroup;

   ngOnInit(): void {
//recuperration du patient connecter
    let json = localStorage.getItem(environnement.APIKEY);
      if (json != null) {
        let user:User = JSON.parse(json) as User;
        console.log(user)

        }

   //actualisation
     this.getallAppointements();
     this.getALLHospitals(),
     this.getALLPatients();
     this.getALLSpecialitys(),

   //add appointements
       this.appointementForm= this.fb.group({

        hospitalId : [``,Validators.required],

        patientId :[``,Validators.required],

        specialityId : [``,Validators.required],

        date : [``,Validators.required]

       });
   }

    // insertion des rdv dans la bd
 onSubmit(){
  this._appointements.createAppointement(this.appointementForm.value).subscribe({
    next:(response :any) =>{
      this.getallAppointements();
    },
    error: error => {
      console.error("Erreur lors de l'enregistrement du rendez vous!", error);
    }
  })

console.log(this.appointementForm.value)

}



   getallAppointements(){

      this._appointements.getAppointements().subscribe({

        next: (response: any)=>{

          // affecte a appointementList la liste des appointement venu de l'api
          this.appointementList = response as Appointements[];

          // affiche  dans la console la liste des appointement
          console.log(this.appointementList)

          //Renvoi de la liste au composant enfant
          this.appointementListOutput.emit(this.appointementList);


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


//***************patient**************** */

getALLPatients(){

  this._patient.getPatients().subscribe({

    next: (response: any)=>{

      // affecte a HospitalList la liste des appointement venu de l'api
      this.patientsList = response as Patient[];

      // affiche  dans la console la liste des appointement
      console.log(this.patientsList)

      //Renvoi de la liste au composant enfant
      this.patientsListOutput.emit(this.patientsList);


  },
      error: error => {
        console.error("Erreur lors de la recuperation des patients!", error);
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
