import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { LayoutComponent } from './pages/layout/layout.component';
import { LayoutDoctorComponent } from './pages/layout-doctor/layout-doctor.component';
import { LayoutHospitalComponent } from './pages/layout-hospital/layout-hospital.component';
import { HospitalComponent } from './components/shared/hospitals/hospital/hospital.component';

const routes: Routes = [
  {path:"", redirectTo:"login", pathMatch:"full"},
  {path:"login", component:LoginComponent},
  {path:"register", component:RegisterComponent},
  {path:"layout", component:LayoutComponent},
  {path:"doctor",component:LayoutDoctorComponent},
  {path:"hospital",component:LayoutHospitalComponent},
  {path:"h",component:HospitalComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
