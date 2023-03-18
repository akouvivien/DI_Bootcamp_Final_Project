import { Component, Input } from '@angular/core';
import { Speciality } from 'src/app/interfaces/speciality';

@Component({
  selector: 'app-speciality-list',
  templateUrl: './speciality-list.component.html',
  styleUrls: ['./speciality-list.component.css']
})
export class SpecialityListComponent {


  @Input() specialityList!:Speciality[];

}
