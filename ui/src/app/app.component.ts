import { Component } from '@angular/core';
import { Doctor } from './interfaces/doctor';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ui';

//remarque pour celui qui  affiche le contenu de tous les enfants
  //Ecouteur captant la détection de remplissage de la liste des user dans le composant <Count>
  // doctorList: Doctor[] = [];

  // ngOnInit() {

  // }


  // getDoctorListFromDoctorComponent(event: Doctor[]) {
  //   this.doctorList = event;
  // }
}
