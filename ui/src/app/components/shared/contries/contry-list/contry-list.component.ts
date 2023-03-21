import { ContryService } from 'src/app/services/api/contry.service';
import { Component, Input, OnInit } from '@angular/core';
import { Contry } from 'src/app/interfaces/contry';
import { User } from 'src/app/interfaces/user';
import { environnement } from 'src/app/environnements/environnement';

@Component({
  selector: 'app-contry-list',
  templateUrl: './contry-list.component.html',
  styleUrls: ['./contry-list.component.css']
})
export class ContryListComponent  implements OnInit{
      //recois la list des contry
    @Input() contryList!:Contry[];

    user!:User 
    constructor(
      private _contry: ContryService
  ){}

  ngOnInit(): void {
    this.delete
  let json = localStorage.getItem(environnement.APIKEY);
  if (json != null) {
    this.user = JSON.parse(json) as User;
    }
  }


  delete(id: number){
    this._contry.deleteContry(id).subscribe({
      next:(response :any) =>{
      },
      error: error => {
        console.error("Erreur lors de la suppression des pays!", error);
      }

    })
    window.location.reload()

  }

  // update(element: Contry){
  //   this._contry.updateContry(element).subscribe({
  //     next:(response :any) =>{

  //     },
  //     error: error => {
  //       console.error("Erreur lors de la mise a jour des pays!", error);
  //     }

  //   })
  //   window.location.reload()

  // }


}
