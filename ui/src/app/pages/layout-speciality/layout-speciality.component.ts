import { Component } from '@angular/core';
import { Speciality } from 'src/app/interfaces/speciality';

@Component({
  selector: 'app-layout-speciality',
  templateUrl: './layout-speciality.component.html',
  styleUrls: ['./layout-speciality.component.css']
})
export class LayoutSpecialityComponent {

  specialityList : Speciality[] = [];

  ngOnInit() {
    this.specialityList
  }

  getSpecialityListFromSpecialityComponent(event: Speciality[]) {
    this.specialityList = event;
  }


}
