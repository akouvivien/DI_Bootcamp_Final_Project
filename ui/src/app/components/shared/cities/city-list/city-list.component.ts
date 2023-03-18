import { Component, Input } from '@angular/core';
import { environnement } from 'src/app/environnements/environnement';
import { City } from 'src/app/interfaces/city';
import { Contry } from 'src/app/interfaces/contry';
import { User } from 'src/app/interfaces/user';
import { CityService } from 'src/app/services/api/city.api.service';

@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.css']
})
export class CityListComponent {

    //recoit la list des villes
    @Input() cityList:any =[];

    //recoit la list des contry
    @Input() contryList!:Contry[];

    // cityList: any = [];
    user!:User 

    constructor(
      private _city: CityService
  ){}

  ngOnInit(): void {
      this.delete
    let json = localStorage.getItem(environnement.APIKEY);
    if (json != null) {
      this.user = JSON.parse(json) as User;
      }

  }

  delete(id: number){

      this._city.deleteCity(id).subscribe({
        next:(response :any) =>{
        },
        error: error => {
          console.error("Erreur lors de la suppression des roles!", error);
        }
  
      })
      window.location.reload()

  }

  update(element: City){

    this._city.updateCity(element).subscribe({
      next:(response :any) =>{

      },
      error: error => {
        console.error("Erreur lors de la mise a jour des villes!", error);
      }

    })
    window.location.reload()

  }



}
