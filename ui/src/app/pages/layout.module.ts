import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { LayoutRoutingModule } from './layout-routing.module';
import { LayoutCityComponent } from './layout-city/layout-city.component';
import { LayoutContryComponent } from './layout-contry/layout-contry.component';
import { LayoutDoctorComponent } from './layout-doctor/layout-doctor.component';
import { LayoutHospitalComponent } from './layout-hospital/layout-hospital.component';
import { LayoutComponent } from './layout/layout.component';
import { CityListComponent } from '../components/shared/cities/city-list/city-list.component';
import { CityComponent } from '../components/shared/cities/city/city.component';
import { ContryListComponent } from '../components/shared/contries/contry-list/contry-list.component';
import { ContryComponent } from '../components/shared/contries/contry/contry.component';
import { DoctorListComponent } from '../components/shared/doctors/doctor-list/doctor-list.component';
import { DoctorComponent } from '../components/shared/doctors/doctor/doctor.component';
import { HospitalListComponent } from '../components/shared/hospitals/hospital-list/hospital-list.component';
import { HospitalComponent } from '../components/shared/hospitals/hospital/hospital.component';
import {NgxPaginationModule} from 'ngx-pagination';


@NgModule({
  declarations: [
    LayoutComponent,
    LayoutDoctorComponent,
    LayoutHospitalComponent,
    LayoutCityComponent,
    LayoutContryComponent,
    DoctorComponent,
    DoctorListComponent,
    HospitalComponent,
    HospitalListComponent,
    CityComponent,
    CityListComponent,
    ContryComponent,
    ContryListComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    LayoutRoutingModule,
    NgxPaginationModule
  ]
})
export class LayoutModule { }
