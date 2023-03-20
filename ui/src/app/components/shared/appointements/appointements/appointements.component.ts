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
import { UserService } from 'src/app/services/storage/user.services';
import { DoctorService } from 'src/app/services/api/doctor.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-appointements',
  templateUrl: './appointements.component.html',
  styleUrls: ['./appointements.component.css']
})
export class AppointementsComponent {

    // recuperation  de l'utilisateur
        user!:User

    //liste des rdv
    appointementList: any = [];

    //L'event qui sera retourné au parent et informera sur l'etat des rdv
    @Output() appointementListOutput: EventEmitter<any> = new EventEmitter<any>();

    //liste des hopitaux
    hospitalList:any = [];

    //L'event qui sera retourné au parent et informera sur l'etat de la liste des category
    @Output() hospitalListOutput: EventEmitter<any> = new EventEmitter<any>();

    //user
    patientsList : any = [];

    //L'event qui sera retourné au parent et informera sur l'etat de la liste des Patients
    @Output() patientsOutput: EventEmitter<any> = new EventEmitter<any>();


    //liste des specialités
    specialityList: any = [];

    //L'event qui sera retourné au parent et informera sur l'etat de la liste des Patients
    @Output() specialityListOutput: EventEmitter<any> = new EventEmitter<any>();


      // la liste des doctors
  doctorList: any = [];


  //L'event qui sera retourné au parent et informera sur l'etat de la liste des doctors
  @Output() doctorListOutput: EventEmitter<any> = new EventEmitter<any>();



    constructor(

      private _appointements: AppointementService,
      private _hospital: HospitalService,
      private _patient : PatientService,
      private _speciality :  SpecialityService,
      // private toast: ToastrService,
      private _doctor : DoctorService,
      private _local : UserService,
      private fb:FormBuilder,
      private route : Router
      ) {  }


//formulaire
appointementForm!: FormGroup;

//formulaire pour recherche par patient
    appointementPaForm!:FormGroup;

//formulaire pour recherche hopital
appointementHoForm!:FormGroup

   ngOnInit(): void {
//recuperration du patient connecter


  console.log(this.user)

    let json = localStorage.getItem(environnement.APIKEY);
      if (json != null) {
        this.user = JSON.parse(json) as User;
        console.log("local storage")
        console.log(this.user)

        }

   //actualisation
    //  this.getallAppointements();
     this.getALLHospitals(),
     this.getALLSpecialitys(),
     this.getALLPatients(),
     this.getalldoctors(),


   //  creation de rdv  ou appointements
       this.appointementForm= this.fb.group({

        // cityId : [``,Validators.required],

        // municipaliityId : [``,Validators.required],

        // categoryId : [``,Validators.required],

        hospitalId : [``,Validators.required],

        patientId :[``,Validators.required],

        doctorId :[``,Validators.required],

        specialityId : [``,Validators.required],

        date : [``,Validators.required]

       });


// rechercher par rapport au patient
       this.appointementPaForm= this.fb.group({

        id :[``,Validators.required],

       });


    // rechercher par rapport a lhopital
   this.appointementHoForm= this.fb.group({

      id :[``,Validators.required],

      });

   }


    // insertion des rdv dans la bd
 onSubmit(){
  this._appointements.createAppointement(this.appointementForm.value).subscribe({
    next:(response :any) =>{
      this.getallAppointements();
      // this.toast.success('votre rendez vous est en cours de traitement')
    },
    error: error => {
      console.error("Erreur lors de l'enregistrement du rendez vous!", error);
      // this.toast.error("Erreur lors de l'enregistrement du rendez vous")
    }
  })

console.log(this.appointementForm.value)

}

//***************liste des doctors************* */

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



//***** recherche par la patient ***********************//
    // insertion des rdv dans la bd
    onSubmit2(){
      this._appointements.ShearchByPatient(this.appointementPaForm.value).subscribe({
        next:(response :any) =>{
          console.log("recherche par patient")
          this.appointementList = response ;
          console.log(this.appointementList)

        //Renvoi de la liste au composant enfant
          this.appointementListOutput.emit(this.appointementList);
        },
        error: error => {
          console.error("consultation de la liste de recherche par patient  a rencontré un soucis!", error);
        }
      })

    console.log(this.appointementPaForm.value)

    }

//***** recherche par hopital  ***********************//
    // insertion des rdv dans la bd
    onSubmit3(){
      this._appointements.ShearchByHospital(this.appointementHoForm.value).subscribe({
        next:(response :any) =>{
          console.log("recherche par hopital")
          this.appointementList = response ;
          console.log(this.appointementList)

        //Renvoi de la liste au composant enfant
          this.appointementListOutput.emit(this.appointementList);
        },
        error: error => {
          console.error("consultation de la liste de recherche par hopital a rencontré un soucis!", error);
        }
      })

    console.log(this.appointementPaForm.value)

    }


    //***********liste de tous les rdv */
   getallAppointements(){

      this._appointements.getAppointements().subscribe({

        next: (response: any)=>{

          // affecte a appointementList la liste des appointement venu de l'api
          this.appointementList = response ;

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
//*************** liste de tous les hospitaux**************** */

getALLHospitals(){

  this._hospital.getHospitals().subscribe({

    next: (response: any)=>{

      // affecte a HospitalList la liste des appointement venu de l'api
      this.hospitalList = response ;

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

//*************** liste de tous les patient**************** */

getALLPatients(){
  console.log("la liste des patients dans l'api")
  this._patient.getPatients().subscribe({

    next: (response: any)=>{

      // affecte a HospitalList la liste des appointement venu de l'api
      this.patientsList = response  ;

      // affiche  dans la console la liste des appointement
      console.log("la liste des patients")
      console.log(this.patientsList)

      //Renvoi de la liste au composant enfant
      this.patientsOutput.emit(this.patientsList);

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
      this.specialityList = response;

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
