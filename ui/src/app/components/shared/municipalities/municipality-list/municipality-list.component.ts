import { MunicipalityService } from 'src/app/services/api/municipality.service';
import { Component, Input } from '@angular/core';
import { environnement } from 'src/app/environnements/environnement';
import { City } from 'src/app/interfaces/city';
import { Municipality } from 'src/app/interfaces/municipality';
import { User } from 'src/app/interfaces/user';

@Component({
  selector: 'app-municipality-list',
  templateUrl: './municipality-list.component.html',
  styleUrls: ['./municipality-list.component.css']
})
export class MunicipalityListComponent {


   //recois la  des villes
    @Input()  cityList:any = [];

    //recois la  des municipalités
    @Input()  municipalityList!:Municipality[];

        // cityList: any = [];
        user!:User 
constructor(

  private _muni : MunicipalityService
){}
    
      ngOnInit(): void {
          this.delete
        let json = localStorage.getItem(environnement.APIKEY);
        if (json != null) {
          this.user = JSON.parse(json) as User;
          }
    
      }
    
      delete(id: number){
    
          this._muni.deleteHMunicipality(id).subscribe({
            next:(response :any) =>{
            },
            error: error => {
              console.error("Erreur lors de la suppression des roles!", error);
            }
      
          })
          window.location.reload()
    
      }

    

}
