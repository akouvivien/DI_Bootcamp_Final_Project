import { environnement } from './../../environnements/environnement';
import { Component, OnInit } from '@angular/core';
import { Router, Routes } from '@angular/router';
import { User } from 'src/app/interfaces/user';



@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent  {

  constructor(private route : Router,){}

   user!:User
   logout(){
    localStorage.removeItem(environnement.APIKEY)
    this.route.navigate(['/authentification/login'])
  }
   

  ngOnInit(): void {
      let json = localStorage.getItem(environnement.APIKEY);
      if (json != null) {
        this.user= JSON.parse(json) as User;
        console.log(this.user.roles.name)

        }
   }


}
