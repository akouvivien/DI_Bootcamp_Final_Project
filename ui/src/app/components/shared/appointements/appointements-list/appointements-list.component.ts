import { Component, Input } from '@angular/core';
import { environnement } from 'src/app/environnements/environnement';
import { User } from 'src/app/interfaces/user';


@Component({
  selector: 'app-appointements-list',
  templateUrl: './appointements-list.component.html',
  styleUrls: ['./appointements-list.component.css']
})
export class AppointementsListComponent {

  @Input() appointementList:any = [];

  @Input() patientsList: any = [];

  @Input() specialityList:any = [];

  @Input() hospitalList: any = [];

  @Input() doctorList: any = [];


  user!:User
  ngOnInit(): void {
    //recuperration du patient connecter
    
    
      console.log(this.user)
    
        let json = localStorage.getItem(environnement.APIKEY);
          if (json != null) {
            this.user = JSON.parse(json) as User;
            console.log("local storage")
            console.log(this.user)
    
            }
          }

}
