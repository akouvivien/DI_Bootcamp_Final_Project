import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Roles } from 'src/app/interfaces/roles';
import { RolesService } from 'src/app/services/api/roles.service';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent {


    //liste des roles
    rolesList:Roles[] = [];



    //L'event qui sera retourné au parent et informera sur l'etat de la liste des Roles
    @Output() rolesListOutput: EventEmitter<Roles[]> = new EventEmitter<Roles[]>();

    constructor(

      private _roles: RolesService,
      private fb:FormBuilder,
      private route : Router
      ) {  }

    //formulaire
    rolesForm!: FormGroup;

   ngOnInit(): void {
   //actualisation des roles
     this.getallRoles();

   //add roles
       this.rolesForm= this.fb.group({

        name : [``,Validators.required]

       });
   }

    // insertion des roles dans la bd
 onSubmit(){
  this._roles.createRole(this.rolesForm.value).subscribe({
    next:(response :any) =>{
      this.getallRoles();
    },
    error: error => {
      console.error("Erreur lors de l'enregistrement des roles!", error);
    }
  })

console.log(this.rolesForm.value)

}



getallRoles(){

      this._roles.getRoles().subscribe({

        next: (response: any)=>{

          // affecte a rolesList la liste des roles venu de l'api
          this.rolesList = response as Roles[];

          // affiche  dans la console la liste des roles
          console.log(this.rolesList)

          //Renvoi de la liste au composant enfant
          this.rolesListOutput.emit(this.rolesList);


      },
          error: error => {
            console.error("Erreur lors de la recuperation des des informations  des roles!", error);
          }
        })

    }
}
