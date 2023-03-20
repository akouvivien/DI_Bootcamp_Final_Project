import { Component, Input } from '@angular/core';


@Component({
  selector: 'app-appointements-list',
  templateUrl: './appointements-list.component.html',
  styleUrls: ['./appointements-list.component.css']
})
export class AppointementsListComponent {

  @Input() appointementList:any = [];

  @Input() patientsList: any = [];

  @Input() specialityList:any = [];

  @Input() hospitalList: any = [];

  @Input() doctorList: any = [];

}
