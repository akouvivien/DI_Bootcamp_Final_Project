import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-assignation-list',
  templateUrl: './assignation-list.component.html',
  styleUrls: ['./assignation-list.component.css']
})
export class AssignationListComponent {
//liste des hopitaux et doctors
  @Input() assignementList:any =[];


  @Input() specialityList:any = [];

  @Input() hospitalList:any = [];

  @Input() doctorList:any =[];
  

  //liste des hopitaux et specialité
  @Input() assignementlSpecialityList: any =[];

  constructor() {

  }
  ngOnInit(): void {
    console.log("assignement relation entre hopital et doctor")
    console.log(this.assignementList)

    console.log("assignement relation entre hopital et la specialite")
    console.log(this.assignementlSpecialityList)
  }
}
