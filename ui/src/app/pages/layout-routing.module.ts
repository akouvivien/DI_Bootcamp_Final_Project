import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LayoutCityComponent } from './layout-city/layout-city.component';
import { LayoutContryComponent } from './layout-contry/layout-contry.component';
import { LayoutDoctorComponent } from './layout-doctor/layout-doctor.component';
import { LayoutHospitalComponent } from './layout-hospital/layout-hospital.component';
import { LayoutComponent } from './layout/layout.component';
import { LayoutAppointementsComponent } from './layout-appointements/layout-appointements.component';
import { LayoutMunicipalityComponent } from './layout-municipality/layout-municipality.component';
import { LayoutRoleComponent } from './layout-role/layout-role.component';
import { LayoutCategoryComponent } from './layout-category/layout-category.component';
import { LayoutAssignementsComponent } from './layout-assignements/layout-assignements.component';
import { LayoutSpecialityComponent } from './layout-speciality/layout-speciality.component';
import { CityListComponent } from '../components/shared/cities/city-list/city-list.component';
import { HospitalListComponent } from '../components/shared/hospitals/hospital-list/hospital-list.component';
import { MunicipalityListComponent } from '../components/shared/municipalities/municipality-list/municipality-list.component';

const routes: Routes = [
{path:'', component:LayoutComponent, children:[
  {path:'doctor',component:LayoutDoctorComponent},
  {path:'hospital',component:LayoutHospitalComponent},
  {path:'cityview',component:CityListComponent},
  {path:'cityview',component:CityListComponent},
  {path:'municipalityview',component:MunicipalityListComponent},
  {path:'hospitalview',component:HospitalListComponent},
  {path:'city',component:LayoutCityComponent, children:[
    
]},
  {path:'contry',component:LayoutContryComponent},
  {path:'appointements',component:LayoutAppointementsComponent},
  {path:'municipality',component:LayoutMunicipalityComponent},
  {path:'role',component:LayoutRoleComponent},
  {path:'category',component:LayoutCategoryComponent},
  {path:'assignements',component:LayoutAssignementsComponent},
  {path:'speciality',component:LayoutSpecialityComponent}

]}

];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes),

  ],
  exports :[RouterModule]

})
export class LayoutRoutingModule { }
