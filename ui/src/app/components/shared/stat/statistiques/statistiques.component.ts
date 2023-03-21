import { CityService } from './../../../../services/api/city.api.service';
import { ContryService } from './../../../../services/api/contry.service';
import { Hospital } from 'src/app/interfaces/hospital';
import { HospitalService } from 'src/app/services/api/hospital.service';
import { Component, Input, OnInit } from '@angular/core';
import { Contry } from 'src/app/interfaces/contry';
import { SpecialityService } from 'src/app/services/api/speciality.service';
import { DoctorService } from 'src/app/services/api/doctor.service';
import { AppointementService } from 'src/app/services/api/appointements.service';
import { PatientService } from 'src/app/services/api/patient.service';
import { MunicipalityService } from 'src/app/services/api/municipality.service';
import { Category } from 'src/app/interfaces/category';
import { CategoryService } from 'src/app/services/api/category.service';

@Component({
  selector: 'app-statistiques',
  templateUrl: './statistiques.component.html',
  styleUrls: ['./statistiques.component.css']
})
export class StatistiquesComponent implements OnInit {
  hospital!: any
  speciality!:any
  doctors!:any
  rdv!:any
  patient!:any
  contry!:any
  city!:any
  muni!:any
  cat!:any


  constructor(

    private _hospital :  HospitalService,
    private _speciality: SpecialityService,
    private _doctors : DoctorService,
    private _rdv : AppointementService,
    private _patients : PatientService,
    private _contry : ContryService,
    private _city : CityService,
    private _munici: MunicipalityService,
    private _cat: CategoryService
  


    ) {  }
  ngOnInit(): void {

    //hopitaux**
    this._hospital.getHospitals().subscribe({

      next: (response: any)=>{
  
        // affecte a specialityList la liste des speciality venu de l'api
        this.hospital = response
  
  
    },
        error: error => {
          console.error("Erreur lors de la recuperation des ,hopitaux!", error);
        }
      });

      //specialité
      this._speciality.getSpeciality().subscribe({

        next: (response: any)=>{
    
          // affecte a specialityList la liste des speciality venu de l'api
          this.speciality = response
    
    
      },
          error: error => {
            console.error("Erreur lors de la recuperation des ,specialités!", error);
          }
        });

        //doctors
      this._doctors.getDoctors().subscribe({

        next: (response: any)=>{
    
          // affecte a specialityList la liste des speciality venu de l'api
          this.doctors = response
    
    
      },
          error: error => {
            console.error("Erreur lors de la recuperation des ,docteurs!", error);
          }
        })


                //rdv
      this._rdv.getAppointements().subscribe({

        next: (response: any)=>{
    
          // affecte a specialityList la liste des speciality venu de l'api
          this.rdv = response
    
    
      },
          error: error => {
            console.error("Erreur lors de la recuperation des ,rendez vous!", error);
          }
        })


    //hopitaux**
    this._patients.getPatients().subscribe({

      next: (response: any)=>{
  
        // affecte a specialityList la liste des speciality venu de l'api
        this.patient = response
  
  
    },
        error: error => {
          console.error("Erreur lors de la recuperation des ,patients!", error);
        }
      });


          //contry**
    this._contry.getContries().subscribe({

      next: (response: any)=>{
  
        // affecte a specialityList la liste des speciality venu de l'api
        this.contry = response
  
  
    },
        error: error => {
          console.error("Erreur lors de la recuperation des ,pays!", error);
        }
      });

           //city**
           this._city.getcities().subscribe({

            next: (response: any)=>{
        
              // affecte a specialityList la liste des speciality venu de l'api
              this.city = response
        
        
          },
              error: error => {
                console.error("Erreur lors de la recuperation des ,villes!", error);
              }
            });

              //city**
           this._munici.getMunicipalies().subscribe({

            next: (response: any)=>{
        
              // affecte a specialityList la liste des speciality venu de l'api
              this.muni = response
        
        
          },
              error: error => {
                console.error("Erreur lors de la recuperation des ,municipalités!", error);
              }
            });

            


            
                       //categories**
           this._munici.getMunicipalies().subscribe({

            next: (response: any)=>{
        
              // affecte a specialityList la liste des speciality venu de l'api
              this.muni = response
        
        
          },
              error: error => {
                console.error("Erreur lors de la recuperation des ,pays!", error);
              }
            });



                                   //categories**
           this._cat.getCategorys().subscribe({

            next: (response: any)=>{
        
              // affecte a specialityList la liste des speciality venu de l'api
              this.cat = response
        
        
          },
              error: error => {
                console.error("Erreur lors de la recuperation des ,pays!", error);
              }
            });

      
      
      
        }


  }

 


 




