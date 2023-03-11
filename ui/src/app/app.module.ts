import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LayoutComponent } from './pages/layout/layout.component';
import { httpService } from './services/auth/auth.service';
import { HttpClientModule } from '@angular/common/http';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { DoctorComponent } from './components/shared/doctors/doctor.component';
import { DoctorListComponent } from './components/shared/doctors/doctor-list/doctor-list.component';
import { LayoutDoctorComponent } from './pages/layout-doctor/layout-doctor.component';
import { HospitalComponent } from './components/shared/hospitals/hospital/hospital.component';
import { HospitalListComponent } from './components/shared/hospitals/hospital-list/hospital-list.component';
import { LayoutHospitalComponent } from './pages/layout-hospital/layout-hospital.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    FooterComponent,
    LayoutComponent,
    NotFoundComponent,
    DoctorComponent,
    DoctorListComponent,
    LayoutDoctorComponent,
    HospitalComponent,
    HospitalListComponent,
    LayoutHospitalComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [httpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
