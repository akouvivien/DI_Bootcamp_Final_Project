import { Component, Input } from '@angular/core';
import { Doctor } from 'src/app/interfaces/doctor';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent {

  //recois la valeur de doctors list en provenance de l'autre composant
  @Input() doctorList!: Doctor[];
}
