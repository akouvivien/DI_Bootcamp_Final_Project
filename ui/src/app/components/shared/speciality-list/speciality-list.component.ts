import { Component, Input } from '@angular/core';
import { environnement } from 'src/app/environnements/environnement';
import { Speciality } from 'src/app/interfaces/speciality';
import { User } from 'src/app/interfaces/user';
import { SpecialityService } from 'src/app/services/api/speciality.service';

@Component({
  selector: 'app-speciality-list',
  templateUrl: './speciality-list.component.html',
  styleUrls: ['./speciality-list.component.css']
})
export class SpecialityListComponent {


  @Input() specialityList!:Speciality[];

  user!:User 
  constructor(
  
    private _speci : SpecialityService
  ){}
      
        ngOnInit(): void {
            this.delete
          let json = localStorage.getItem(environnement.APIKEY);
          if (json != null) {
            this.user = JSON.parse(json) as User;
            }
      
        }
      
        delete(id: number){
      
            this._speci.deleteSpeciality(id).subscribe({
              next:(response :any) =>{
              },
              error: error => {
                console.error("Erreur lors de la suppression des specialités!", error);
              }
        
            })
            window.location.reload()
      
        }
  
      

}
