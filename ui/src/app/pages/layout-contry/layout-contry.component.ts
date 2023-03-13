import { Component } from '@angular/core';
import { Contry } from 'src/app/interfaces/contry';

@Component({
  selector: 'app-layout-contry',
  templateUrl: './layout-contry.component.html',
  styleUrls: ['./layout-contry.component.css']
})
export class LayoutContryComponent {


  contryList : Contry[] = [];

  ngOnInit() {
    this.contryList
  }


  getContryListFromContryComponent(event: Contry[]) {
    this.contryList = event;
  }

}
