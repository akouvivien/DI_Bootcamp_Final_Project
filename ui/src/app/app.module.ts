import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { httpService } from './services/auth/auth.service';
import { HttpClientModule } from '@angular/common/http';
import { DataTablesModule } from 'angular-datatables';
import { SpecialityComponent } from './components/shared/speciality/speciality.component';
import { SpecialityListComponent } from './components/shared/speciality-list/speciality-list.component';
import { StatistiquesComponent } from './components/shared/stat/statistiques/statistiques.component';
import { ToastrModule } from 'ngx-toastr/toastr/toastr.module';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    // ToastrModule.forRoot(), // ToastrModule added

  ],
  // exports: [ToastrModule],
  providers: [httpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
