import { environnement } from './../../environnements/environnement';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/interfaces/user';



@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent  {

   user!:User

  ngOnInit(): void {
      let json = localStorage.getItem(environnement.APIKEY);
      if (json != null) {
        let user:User = JSON.parse(json) as User;
        console.log(user.roles.id)

        }
   }


}
