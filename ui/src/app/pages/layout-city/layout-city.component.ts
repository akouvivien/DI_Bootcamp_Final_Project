import { City } from 'src/app/interfaces/city';
import { Component } from '@angular/core';
import { Contry } from 'src/app/interfaces/contry';

@Component({
  selector: 'app-layout-city',
  templateUrl: './layout-city.component.html',
  styleUrls: ['./layout-city.component.css']
})
export class LayoutCityComponent {

  cityList: any = [];

  contryList : Contry[] = [];

  ngOnInit() {

    this.cityList,

    this.contryList
  }

  getcityListFromCityComponent(event: any) {
    this.cityList = event;
  }

  getContryListFromCityComponent(event: any) {
    this.contryList = event;
  }

}
