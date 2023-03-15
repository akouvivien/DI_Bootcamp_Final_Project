import { Doctor } from 'src/app/interfaces/doctor';
import { Component } from '@angular/core';
import { Appointements } from 'src/app/interfaces/appointements';
import { Assignements } from 'src/app/interfaces/assignements';
import { Hospital } from 'src/app/interfaces/hospital';
import { Patient } from 'src/app/interfaces/patient';
import { Speciality } from 'src/app/interfaces/speciality';

@Component({
  selector: 'app-layout-assignements',
  templateUrl: './layout-assignements.component.html',
  styleUrls: ['./layout-assignements.component.css']
})
export class LayoutAssignementsComponent {

  hospitalList: Hospital[] = [];

  assignementList : Assignements[] = [];

  specialityList : Speciality[] = [];

  doctorList : Doctor[] = [];

  ngOnInit() {

    this.hospitalList,

    this.specialityList,

    this.assignementList


  }

  getHospitalListFromAssignementsComponent(event: Hospital[]) {
    this.hospitalList = event;
  }

  getDoctorListFromAppointementsComponent(event: Doctor[]) {
    this.doctorList = event;
  }

  getSpecialityListFromAssignementsComponent(event: Speciality[]) {
    this.specialityList = event;
  }

  getAssignementsListFromAssignementsComponent(event: Assignements[]) {
    this.assignementList = event;
  }


}
