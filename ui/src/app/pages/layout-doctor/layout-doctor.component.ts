import { Component, OnInit } from '@angular/core';
import { Doctor } from 'src/app/interfaces/doctor';
import { Speciality } from 'src/app/interfaces/speciality';

@Component({
  selector: 'app-layout-doctor',
  templateUrl: './layout-doctor.component.html',
  styleUrls: ['./layout-doctor.component.css']
})
export class LayoutDoctorComponent implements OnInit {


  doctorList: any = [];
  specialityList: Speciality[]= []

  ngOnInit() {
    this.doctorList
    console.log("list des doctorsssssssssssssssssss layout ")
    console.log(this.doctorList)
  }


  getDoctorListFromDoctorComponent(event: any) {
    console.log("list dans l'envoyeur layout ")
    console.log(event)
    this.doctorList = event;
  }

  getSpecialityistFromDoctorComponent(event: Speciality[]) {
    console.log("list dans l'envoyeur layout ")
    console.log(event)
    this.specialityList = event;
  }

}
