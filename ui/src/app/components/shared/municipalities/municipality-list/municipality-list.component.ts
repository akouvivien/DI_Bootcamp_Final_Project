import { Component, Input } from '@angular/core';
import { City } from 'src/app/interfaces/city';
import { Municipality } from 'src/app/interfaces/municipality';

@Component({
  selector: 'app-municipality-list',
  templateUrl: './municipality-list.component.html',
  styleUrls: ['./municipality-list.component.css']
})
export class MunicipalityListComponent {


   //recois la  des villes
  @Input()  cityList!:City[];

    //recois la  des municipalités
    @Input()  municipalityList!:Municipality[];

}
