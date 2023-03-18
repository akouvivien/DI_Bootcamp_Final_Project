import { Component, OnInit } from '@angular/core';
import { environnement } from 'src/app/environnements/environnement';
import { City } from 'src/app/interfaces/city';
import { Contry } from 'src/app/interfaces/contry';
import { Municipality } from 'src/app/interfaces/municipality';
import { User } from 'src/app/interfaces/user';

@Component({
  selector: 'app-layout-municipality',
  templateUrl: './layout-municipality.component.html',
  styleUrls: ['./layout-municipality.component.css']
})
export class LayoutMunicipalityComponent {


  cityList: City[] = [];

  municipalityList : Municipality[] = [];

  ngOnInit() {

    this.cityList,

    this.municipalityList
  
}

  getcityListFromMunicipalityComponent(event: any) {
    this.cityList = event;
  }

  getMunicipalityListFromMunicipalityComponent(event: any) {
    this.municipalityList = event;
  }

}
