import { Doctor } from 'src/app/interfaces/doctor';
import { Component } from '@angular/core';
import { Assignements } from 'src/app/interfaces/assignements';
import { Hospital } from 'src/app/interfaces/hospital';
import { Speciality } from 'src/app/interfaces/speciality';

@Component({
  selector: 'app-layout-assignements',
  templateUrl: './layout-assignements.component.html',
  styleUrls: ['./layout-assignements.component.css']
})
export class LayoutAssignementsComponent {

  hospitalList: any = [];

  assignementList : any = [];

  specialityList : any = [];

  doctorList : any = [];

  assignementlSpecialityList: any =[];


  ngOnInit() {
    this.doctorList,

    this.hospitalList,

    this.specialityList,

    this.assignementList

    console.log("retour appel api assignement dans le layout")
    console.log(this.assignementList)
    console.log(this.specialityList)

  }

  getHospitalListFromAssignementsComponent(event: Hospital[]) {
    console.log("l'hospital dans le layout retour")
    console.log(event)
    this.hospitalList = event;
  }

  getDoctorListFromAssignementsComponent(event: Doctor[]) {
    console.log("l'doctor dans le layout retour")
    console.log(event)
    this.doctorList = event;
  }

  getSpecialityListFromAssignementsComponent(event: Speciality[]) {
    console.log("l'speciality dans le layout retour")
    console.log(event)
    this.specialityList = event;
  }

  getAssignementsListFromAssignementsComponent(event: any) {
    console.log("l'assignements dans le layout retour")
    this.assignementlSpecialityList = event;
  }

  assignementlSpecialityListFromAssignementsComponent(event: any) {
    console.log("l'speci affect dans le layout retour")
    this.assignementList = event;
  }

}
