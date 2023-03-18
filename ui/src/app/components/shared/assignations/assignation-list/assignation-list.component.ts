import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-assignation-list',
  templateUrl: './assignation-list.component.html',
  styleUrls: ['./assignation-list.component.css']
})
export class AssignationListComponent implements OnInit {

  @Input() assignementList:any =[];

  @Input() specialityList:any = [];

  @Input() hospitalList:any = [];

  @Input() doctorList:any =[];

  constructor() {

  }
  ngOnInit(): void {
    console.log("assignement dans la liste")
    console.log(this.assignementList)

    console.log("assignement dans la specialite")
    console.log(this.specialityList)
  }
}
