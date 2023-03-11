import { Component, OnInit } from '@angular/core';
import { Doctor } from 'src/app/interfaces/doctor';

@Component({
  selector: 'app-layout-doctor',
  templateUrl: './layout-doctor.component.html',
  styleUrls: ['./layout-doctor.component.css']
})
export class LayoutDoctorComponent implements OnInit {

  
  doctorList: Doctor[] = [];

  ngOnInit() {
    this.doctorList
  }


  getDoctorListFromDoctorComponent(event: Doctor[]) {
    this.doctorList = event;
  }

}
