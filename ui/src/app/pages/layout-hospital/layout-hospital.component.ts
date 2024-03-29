import { Municipality } from 'src/app/interfaces/municipality';
import { Category } from './../../interfaces/category';
import { Hospital } from './../../interfaces/hospital';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-layout-hospital',
  templateUrl: './layout-hospital.component.html',
  styleUrls: ['./layout-hospital.component.css']
})
export class LayoutHospitalComponent implements OnInit {


  // hospitalList: any = [];

  categoryList : Category[] = [];

  municipalityList : Municipality[] = [];

  ngOnInit() {



    this.categoryList,

    this.municipalityList
  }


  // getHospitalListFromHospitalComponent(event: any) {
  //   console.log("la liste des hopitaux")
  //   this.hospitalList = event;
  // }

  getCategoryListFromHospitalComponent(event: Category[]) {
    this.categoryList = event;
  }

  getMunicipalityListFromHospitalComponent(event: Municipality[]) {
    this.municipalityList = event;
  }


}
