import { LayoutMunicipalityComponent } from './layout-municipality/layout-municipality.component';
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
import { NgxPaginationModule} from 'ngx-pagination';
import { DataTablesModule } from 'angular-datatables';
import { AppointementsListComponent } from '../components/shared/appointements/appointements-list/appointements-list.component';
import { AppointementsComponent } from '../components/shared/appointements/appointements/appointements.component';
import { LayoutAppointementsComponent } from './layout-appointements/layout-appointements.component';
import { MunicipalityListComponent } from '../components/shared/municipalities/municipality-list/municipality-list.component';
import { MunicipalityComponent } from '../components/shared/municipalities/municipality/municipality.component';
import { RoleListComponent } from '../components/shared/roles/role-list/role-list.component';
import { RoleComponent } from '../components/shared/roles/role/role.component';
import { LayoutRoleComponent } from './layout-role/layout-role.component';
import { CategoryListComponent } from '../components/shared/categories/category-list/category-list.component';
import { CategoryComponent } from '../components/shared/categories/category/category.component';
import { LayoutCategoryComponent } from './layout-category/layout-category.component';
import { LayoutAssignementsComponent } from './layout-assignements/layout-assignements.component';
import { AssignationListComponent } from '../components/shared/assignations/assignation-list/assignation-list.component';
import { AssignationComponent } from '../components/shared/assignations/assignation/assignation.component';
import { LayoutSpecialityComponent } from './layout-speciality/layout-speciality.component';
import { SpecialityListComponent } from '../components/shared/speciality-list/speciality-list.component';
import { SpecialityComponent } from '../components/shared/speciality/speciality.component';


@NgModule({
  declarations: [
    LayoutComponent,
    LayoutDoctorComponent,
    LayoutHospitalComponent,
    LayoutCityComponent,
    LayoutContryComponent,
    LayoutMunicipalityComponent,
    LayoutAppointementsComponent,
    LayoutRoleComponent,
    LayoutCategoryComponent,
    LayoutAssignementsComponent,
    DoctorComponent,
    DoctorListComponent,
    HospitalComponent,
    HospitalListComponent,
    CityComponent,
    CityListComponent,
    ContryComponent,
    ContryListComponent,
    AppointementsComponent,
    AppointementsListComponent,
    MunicipalityComponent,
    MunicipalityListComponent,
    RoleComponent,
    RoleListComponent,
    CategoryComponent,
    CategoryListComponent,
    AssignationComponent,
    AssignationListComponent,
    LayoutSpecialityComponent,
    SpecialityComponent,
    SpecialityListComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    LayoutRoutingModule,
    NgxPaginationModule,
    DataTablesModule
  ]
})
export class LayoutModule { }
