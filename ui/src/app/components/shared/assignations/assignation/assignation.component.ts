import { User } from 'src/app/interfaces/user';
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
import { HospitalDoctorService } from 'src/app/services/api/hospitaldoctor.service';
import { HospitalSpecialityService } from 'src/app/services/api/hospitalspeciality.service';
import { environnement } from 'src/app/environnements/environnement';

@Component({
  selector: 'app-assignation',
  templateUrl: './assignation.component.html',
  styleUrls: ['./assignation.component.css']
})
export class AssignationComponent {


  user! : User
    //liste des assignements et docteurs
    assignementlList: any = [];

    //L'event qui sera retourné au parent et informera sur l'etat de la liste des affectations
    @Output() assignementlListOutput: EventEmitter<any> = new EventEmitter<any>();

    //liste des hopitaux
    hospitalList: any = [];

    //L'event qui sera retourné au parent et informera sur l'etat de la liste des category
    @Output() hospitalListOutput: EventEmitter<any> = new EventEmitter<any>();

    //liste des specialités
    specialityList: any = [];

    //L'event qui sera retourné au parent et informera sur l'etat de la liste des Patients
    @Output() specialityListOutput: EventEmitter<any> = new EventEmitter<any>();


    //liste des doctors
    doctorList: any = [];

    //L'event qui sera retourné au parent et informera sur l'etat de la liste des Patients
    @Output() doctorListOutput: EventEmitter<any> = new EventEmitter<any>();

    assignementlSpecialityList: any =[];

        //L'event qui sera retourné au parent et informera sur l'etat de la liste des Patients
        @Output() aassignementlSpecialityListOutput: EventEmitter<any> = new EventEmitter<any>();

    constructor(
      private _hospital: HospitalService,
      private _speciality :  SpecialityService,
      private _doctor : DoctorService,
      private _assign : HospitalDoctorService,
      private _assignspe: HospitalSpecialityService,
      private fb:FormBuilder,
      private route : Router
      // , private modalService: NgbModal
      ) {  }


    //formulaire
    assignementForm!: FormGroup;

    //specialité
    assignementspeForm!: FormGroup

   ngOnInit(): void {

    let json = localStorage.getItem(environnement.APIKEY);
    if (json != null) {
      this.user = JSON.parse(json) as User;
      console.log("local storage")
      console.log(this.user)

      }

   //actualisation
     this.getallAssignements();
     this.getALLHospitals(),
     this.getALLSpecialitys(),
     this.getALLDoctors(),
     this.getallAssignementHospitalSpecialitys()

   //add appointements
       this.assignementForm= this.fb.group({

        hospital : [``,Validators.required],

        doctor :[``,Validators.required],

       });

     //add appointements
     this.assignementspeForm= this.fb.group({

      hospital : [``,Validators.required],

      speciality :[``,Validators.required],


     });
   }

    // effectuer des assignements dans la bd entre les docteurs et les hopitaux

 onSubmit(){

    this._assign.AssignHospitalDoctor(this.assignementForm.value).subscribe({
      next:(response :any) =>{
        this.getallAssignements();
       alert("doctor inserer avec sucess")
      },
      error: error => {
        console.error("Erreur lors de l'enregistrement des assignements!", error);
      }
    })

console.log(this.assignementForm.value)

}


// assignations des specialités et des hoptitaux
onSubmit2(){

  this._assignspe.AssignHospitalSpeciality(this.assignementspeForm.value).subscribe({
    next:(response :any) =>{
      this.getallAssignementHospitalSpecialitys();
      alert("specialité inserer avec sucess")
    },
    error: error => {
      console.error("Erreur lors de l'enregistrement des assignements!", error);
    }
  })

console.log(this.assignementspeForm.value)

}

//*********specialité par hopital */

getallAssignementHospitalSpecialitys(){

      this._assignspe.getHospitalSpeciality().subscribe({

        next: (response: any)=>{

          // affecte a assignementlList la liste des assignements venue de l'api
          this.assignementlSpecialityList = response ;

          // affiche  dans la console la liste des assignement
          console.log("la relation entre relation entre specialité et hopital dans le principal ")
          console.log(this.assignementlSpecialityList)

          //Renvoi de la liste au composant enfant
          this.aassignementlSpecialityListOutput.emit(this.assignementlSpecialityList);


      },
          error: error => {
            console.error("Erreur lors de la recuperation des des informations des rendez vous!", error);
          }
        })

}

//****** doctor et hopital  */
getallAssignements(){

  this._assign.getHospitalDoctor().subscribe({

    next: (response: any)=>{

      // affecte a assignementlList la liste des assignements venue de l'api
      console.log("la relation entre hopital  et le doctor dans le principal")
      this.assignementlList = response ;

      // affiche  dans la console la liste des assignement
      console.log(this.assignementlList)

      //Renvoi de la liste au composant enfant
      this.assignementlListOutput.emit(this.assignementlList);

  },
      error: error => {
        console.error("Erreur lors de la recuperation des des informations des rendez vous!", error);
      }

    })

// window.location.reload()

}
//***************hospital**************** */

getALLHospitals(){

  this._hospital.getHospitals().subscribe({

    next: (response: any)=>{

      // affecte a HospitalList la liste des appointement venu de l'api
      this.hospitalList = response ;

      // affiche  dans la console la liste des appointement
      // console.log(this.hospitalList)

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
      this.specialityList = response;

      // affiche  dans la console la liste des speciality
      // console.log(this.specialityList)

      //Renvoi de la liste au composant enfant
      this.specialityListOutput.emit(this.specialityList);


  },
      error: error => {
        console.error("Erreur lors de la recuperation des ,specialités!", error);
      }
    })

}



//*******doctors */

getALLDoctors(){

  this._doctor.getDoctors().subscribe({

    next: (response: any)=>{

      // affecte a specialityList la liste des speciality venu de l'api
      this.doctorList = response ;

      // affiche  dans la console la liste des speciality
      // console.log(this.doctorList)

      //Renvoi de la liste au composant enfant
      this.doctorListOutput.emit(this.doctorList);


  },
      error: error => {
        console.error("Erreur lors de la recuperation des ,doctors!", error);
      }
    })

}

}
