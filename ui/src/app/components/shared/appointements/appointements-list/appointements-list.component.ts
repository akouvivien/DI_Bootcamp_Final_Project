import { Patient } from './../../../../interfaces/patient';
import { Component, Input } from '@angular/core';
import { Appointements } from 'src/app/interfaces/appointements';
import { Hospital } from 'src/app/interfaces/hospital';
import { Speciality } from 'src/app/interfaces/speciality';

@Component({
  selector: 'app-appointements-list',
  templateUrl: './appointements-list.component.html',
  styleUrls: ['./appointements-list.component.css']
})
export class AppointementsListComponent {

  @Input() appointementList!:Appointements[];

  @Input() patientsList!:Patient[];

  @Input() specialityList!:Speciality[];

  @Input() hospitalList!:Hospital[];

}
