import { Component } from '@angular/core';
import { City } from 'src/app/interfaces/city';
import { Contry } from 'src/app/interfaces/contry';
import { Municipality } from 'src/app/interfaces/municipality';

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

  getcityListFromMunicipalityComponent(event: City[]) {
    this.cityList = event;
  }

  getMunicipalityListFromMunicipalityComponent(event: Municipality[]) {
    this.municipalityList = event;
  }

}
