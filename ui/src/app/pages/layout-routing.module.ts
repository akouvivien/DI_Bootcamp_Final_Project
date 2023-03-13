import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LayoutCityComponent } from './layout-city/layout-city.component';
import { LayoutContryComponent } from './layout-contry/layout-contry.component';
import { LayoutDoctorComponent } from './layout-doctor/layout-doctor.component';
import { LayoutHospitalComponent } from './layout-hospital/layout-hospital.component';
import { LayoutComponent } from './layout/layout.component';
import { DoctorListComponent } from '../components/shared/doctors/doctor-list/doctor-list.component';
import { DoctorComponent } from '../components/shared/doctors/doctor/doctor.component';


const routes: Routes = [
{path:'', component:LayoutComponent, children:[
  {path:'doctor',component:LayoutDoctorComponent},
  {path:'hospital',component:LayoutHospitalComponent, children: [


  ]},
  {path:'city',component:LayoutCityComponent, children: [


  ]},
  {path:'contry',component:LayoutContryComponent, children: [


  ]},
]}

];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports :[RouterModule]

})
export class LayoutRoutingModule { }
