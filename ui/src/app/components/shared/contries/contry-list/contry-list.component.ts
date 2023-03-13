import { Component, Input, OnInit } from '@angular/core';
import { Contry } from 'src/app/interfaces/contry';

@Component({
  selector: 'app-contry-list',
  templateUrl: './contry-list.component.html',
  styleUrls: ['./contry-list.component.css']
})
export class ContryListComponent  implements OnInit{
  ngOnInit(): void {
    console.log(this.collection);
  }
  p: number = 1;
      //recois la list des contry
    @Input() contryList!:Contry[];


    collection =[
      {id:1,name:"james"},
      {id:2,name:"james"}
    ];
}
