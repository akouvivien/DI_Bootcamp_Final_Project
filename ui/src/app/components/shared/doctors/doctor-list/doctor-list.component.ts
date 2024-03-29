import { User } from 'src/app/interfaces/user';
import { DoctorService } from 'src/app/services/api/doctor.service';
import { Component, Input, OnInit } from '@angular/core';
import { Doctor } from 'src/app/interfaces/doctor';
import { Speciality } from 'src/app/interfaces/speciality';
import { environnement } from 'src/app/environnements/environnement';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent  implements OnInit{


  user !: User
  //recois la valeur de doctors list en provenance de l'autre composant
  @Input() doctorList: any = [];


  //recois la valeur des specialités list en provenance de l'autre composant
  @Input() specialityList: Speciality[] = [];




  constructor(
    private _doctor: DoctorService
){}
ngOnInit(): void {
  this.delete

  let json = localStorage.getItem(environnement.APIKEY);
  if (json != null) {
    this.user = JSON.parse(json) as User;
    console.log("local storage")
    console.log(this.user)

    }
}



delete(id: number){
  this._doctor.deleteDoctor(id).subscribe({
    next:(response :any) =>{
    },
    error: error => {
      console.error("Erreur lors de la suppression des doctors!", error);
    }

  })
  window.location.reload()

}

update(element: Doctor){
  this._doctor.updateDoctor(element).subscribe({
    next:(response :any) =>{

    },
    error: error => {
      console.error("Erreur lors de la mise a jour des doctors!", error);
    }

  })
  window.location.reload()

}


}
