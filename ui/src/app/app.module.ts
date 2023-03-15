import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { httpService } from './services/auth/auth.service';
import { HttpClientModule } from '@angular/common/http';
import { DataTablesModule } from 'angular-datatables';
import { AssignationComponent } from './components/shared/assignations/assignation/assignation.component';
import { AssignationListComponent } from './components/shared/assignations/assignation-list/assignation-list.component';




@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    AssignationComponent,
    AssignationListComponent

 

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
