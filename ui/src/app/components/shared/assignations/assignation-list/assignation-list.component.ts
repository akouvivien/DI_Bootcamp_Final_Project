import { Component, Input } from '@angular/core';
import { Assignements } from 'src/app/interfaces/assignements';
import { Doctor } from 'src/app/interfaces/doctor';
import { Hospital } from 'src/app/interfaces/hospital';
import { Speciality } from 'src/app/interfaces/speciality';

@Component({
  selector: 'app-assignation-list',
  templateUrl: './assignation-list.component.html',
  styleUrls: ['./assignation-list.component.css']
})
export class AssignationListComponent {


  @Input() assignementList!:Assignements[];

  @Input() specialityList!:Speciality[];

  @Input() hospitalList!:Hospital[];

  @Input() doctorList!:Doctor[];

}
