import { Component, Input } from '@angular/core';
import { Category } from 'src/app/interfaces/category';
import { Hospital } from 'src/app/interfaces/hospital';
import { Municipality } from 'src/app/interfaces/municipality';

@Component({
  selector: 'app-hospital-list',
  templateUrl: './hospital-list.component.html',
  styleUrls: ['./hospital-list.component.css']
})
export class HospitalListComponent {

  //recois la list des hopitaux
  @Input() hospitalList!:Hospital[];

  //recois la  des categories
  @Input() categoryList!:Category[];

  //recois la  des municipalités
  @Input()  municipalityList!:Municipality[];

}
