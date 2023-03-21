import { Doctor } from 'src/app/interfaces/doctor';
import { Component } from '@angular/core';
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

    this.assignementList,

    this.assignementlSpecialityList

    console.log("retour appel api assignement dans le layout")
    console.log(this.assignementList)
    console.log(this.assignementlSpecialityList)

  }

  getHospitalListFromAssignementsComponent(event: Hospital[]) {
    // console.log("l'hospital dans le layout retour")
    // console.log(event)
    this.hospitalList = event;
  }

  getDoctorListFromAssignementsComponent(event: Doctor[]) {
    // console.log("l'doctor dans le layout retour")
    // console.log(event)
    this.doctorList = event;
  }

  getSpecialityListFromAssignementsComponent(event: Speciality[]) {
    // console.log("l'speciality dans le layout retour")
    // console.log(event)
    this.specialityList = event;
  }

  getAssignementsListFromAssignementsComponent(event: any) {
    console.log("relation entre docteur et hopital dans la vue")
    console.log(event)
    this.assignementList = event;
  }

  getassignementlSpecialityListFromAssignementsComponent(event: any) {
    console.log("relation entre hopital et specialité dans la vue")
    console.log(event)
    this.assignementlSpecialityList   = event;
  }

}
