import { User } from 'src/app/interfaces/user';
import { Component, Input, OnInit } from '@angular/core';
import { environnement } from 'src/app/environnements/environnement';

@Component({
  selector: 'app-assignation-list',
  templateUrl: './assignation-list.component.html',
  styleUrls: ['./assignation-list.component.css']
})
export class AssignationListComponent implements OnInit {
//liste des hopitaux et doctors
  @Input() assignementList:any =[];

  @Input() specialityList:any = [];

  @Input() hospitalList:any = [];

  @Input() doctorList:any =[];


  //liste des hopitaux et specialité
  @Input() assignementlSpecialityList: any =[];

  user !:User
  constructor() {

  }
  ngOnInit(): void {
    console.log("assignement relation entre hopital et doctor")
    console.log(this.assignementList)
    this.assignementList

    console.log("assignement relation entre hopital et la specialite")
    console.log(this.assignementlSpecialityList)
    this.assignementlSpecialityList


    console.log(this.user)

    let json = localStorage.getItem(environnement.APIKEY);
      if (json != null) {
        this.user = JSON.parse(json) as User;
        console.log("local storage")
        console.log(this.user)

        }
  }
}
