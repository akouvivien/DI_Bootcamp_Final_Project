import { Component, Input } from '@angular/core';
import { City } from 'src/app/interfaces/city';
import { Contry } from 'src/app/interfaces/contry';

@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.css']
})
export class CityListComponent {

    //recois la list des villes
    @Input() cityList!:City[];

    //recois la list des contry
    @Input() contryList!:Contry[];

    

}
