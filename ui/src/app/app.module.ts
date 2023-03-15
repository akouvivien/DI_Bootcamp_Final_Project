import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { httpService } from './services/auth/auth.service';
import { HttpClientModule } from '@angular/common/http';
import { DataTablesModule } from 'angular-datatables';
import { MunicipalityComponent } from './components/shared/municipalities/municipality/municipality.component';
import { MunicipalityListComponent } from './components/shared/municipalities/municipality-list/municipality-list.component';




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
    DataTablesModule

  ],
  providers: [httpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
