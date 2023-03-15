import { Component, Input, OnInit } from '@angular/core';
import { Contry } from 'src/app/interfaces/contry';

@Component({
  selector: 'app-contry-list',
  templateUrl: './contry-list.component.html',
  styleUrls: ['./contry-list.component.css']
})
export class ContryListComponent  implements OnInit{
      //recois la list des contry
    @Input() contryList!:Contry[];


    // dtOptions: DataTables.Settings={};

    ngOnInit(): void {
      // this.dtOptions = {
      //   pagingType: 'full_numbers',
      //   pageLength: 10,
      //   processing: true
      // };
    }
}
