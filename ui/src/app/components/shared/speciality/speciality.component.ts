import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Speciality } from 'src/app/interfaces/speciality';
import { SpecialityService } from 'src/app/services/api/speciality.service';

@Component({
  selector: 'app-speciality',
  templateUrl: './speciality.component.html',
  styleUrls: ['./speciality.component.css']
})
export class SpecialityComponent {

// liste des specialités
  specialityList: Speciality[]=[];


  //L'event qui sera retourné au parent et informera sur l'etat des rdv
  @Output() specialityListOutput: EventEmitter<Speciality[]> = new EventEmitter<Speciality[]>();


  constructor(

    private _speciality :  SpecialityService,
    private fb:FormBuilder,
    private route : Router

    ) {  }


  //formulaire
  specialitytForm!: FormGroup;

 ngOnInit(): void {

   this.getALLSpecialitys(),

 //add appointements
     this.specialitytForm= this.fb.group({

      name : [``,Validators.required]

     });

 }

  // insertion des specialités dans la bd
onSubmit(){
this._speciality.createSpeciality(this.specialitytForm.value).subscribe({
  next:(response :any) =>{
    this.getALLSpecialitys();
  },
  error: error => {
    console.error("Erreur lors de l'enregistrement du rendez vous!", error);
  }
})

console.log(this.specialitytForm.value)

}

  //***************speciality**************** */

getALLSpecialitys(){

  this._speciality.getSpeciality().subscribe({

    next: (response: any)=>{

      // affecte a specialityList la liste des speciality venu de l'api
      this.specialityList = response as Speciality[];

      // affiche  dans la console la liste des speciality
      console.log(this.specialityList)

      //Renvoi de la liste au composant enfant
      this.specialityListOutput.emit(this.specialityList);


  },
      error: error => {
        console.error("Erreur lors de la recuperation des ,specialités!", error);
      }
    })

}

}
