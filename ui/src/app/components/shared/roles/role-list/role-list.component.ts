import { Component, Input, OnInit } from '@angular/core';
import { Roles } from 'src/app/interfaces/roles';
import { RolesService } from 'src/app/services/api/roles.service';

@Component({
  selector: 'app-role-list',
  templateUrl: './role-list.component.html',
  styleUrls: ['./role-list.component.css']
})
export class RoleListComponent implements OnInit {

  @Input() rolesList!:Roles[];


  constructor(
      private _roles: RolesService
  ){}
  ngOnInit(): void {
    this.delete
  }



  delete(id: number){
    this._roles.deleteRole(id).subscribe({
      next:(response :any) =>{
        
      },
      error: error => {
        console.error("Erreur lors de la suppression des roles!", error);
      }
      
    })
    window.location.reload()
  
  }




}
