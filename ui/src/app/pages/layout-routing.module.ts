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

const routes: Routes = [
{path:'', component:LayoutComponent, children:[
  {path:'doctor',component:LayoutDoctorComponent},
  {path:'hospital',component:LayoutHospitalComponent},
  {path:'city',component:LayoutCityComponent},
  {path:'contry',component:LayoutContryComponent},
  {path:'appointements',component:LayoutAppointementsComponent},
  {path:'municipality',component:LayoutMunicipalityComponent},
  {path:'role',component:LayoutRoleComponent},
  {path:'category',component:LayoutCategoryComponent},
  {path:'assignements',component:LayoutAssignementsComponent}

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
