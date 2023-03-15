import { Appointements } from 'src/app/interfaces/appointements';
import { Component } from '@angular/core';
import { Hospital } from 'src/app/interfaces/hospital';
import { Patient } from 'src/app/interfaces/patient';
import { Speciality } from 'src/app/interfaces/speciality';

@Component({
  selector: 'app-layout-appointements',
  templateUrl: './layout-appointements.component.html',
  styleUrls: ['./layout-appointements.component.css']
})
export class LayoutAppointementsComponent {


  hospitalList: Hospital[] = [];

  patientsList : Patient[] = [];

  specialityList : Speciality[] = [];

  appointementList : Appointements[] = [];

  ngOnInit() {

    this.hospitalList,

    this.patientsList,

    this.specialityList,

    this.appointementList

  }


  getHospitalListFromHospitalComponent(event: Hospital[]) {
    this.hospitalList = event;
  }


  getPatientListFromAppointementsComponent(event: Patient[]) {
    this.patientsList = event;
  }

  getSpecialityListFromAppointementsComponent(event: Speciality[]) {
    this.specialityList = event;
  }

  getAppointementsListFromAppointementsComponent(event: Appointements[]) {
    this.appointementList = event;
  }

}
