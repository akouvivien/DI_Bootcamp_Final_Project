import { Appointements } from 'src/app/interfaces/appointements';
import { Component } from '@angular/core';
import { Hospital } from 'src/app/interfaces/hospital';
import { Speciality } from 'src/app/interfaces/speciality';
import { User } from 'src/app/interfaces/user';
import { AnyCatcher } from 'rxjs/internal/AnyCatcher';

@Component({
  selector: 'app-layout-appointements',
  templateUrl: './layout-appointements.component.html',
  styleUrls: ['./layout-appointements.component.css']
})
export class LayoutAppointementsComponent {

  hospitalList: any= [];

  patientsList: any = [];

  specialityList : any = [];

  appointementList : any = [];

  doctorList:  any = [];

  ngOnInit() {

    this.hospitalList,

    this.patientsList,

    this.specialityList,

    this.appointementList,

    this.doctorList


  }

  getHospitalListFromHospitalComponent(event: any) {
    this.hospitalList = event;
  }

  getPatientListFromAppointementsComponent(event: any) {
    this.patientsList = event;
  }

  getSpecialityListFromAppointementsComponent(event: any) {
    this.specialityList = event;
  }

  getAppointementsListFromAppointementsComponent(event: any) {
    this.appointementList = event;
  }

  getDoctorsListFromAppointementsComponent(event: any) {
    this.doctorList = event;
  }

}
