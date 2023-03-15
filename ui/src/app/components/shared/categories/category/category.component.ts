import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Category } from 'src/app/interfaces/category';
import { CategoryService } from 'src/app/services/api/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent {


    //liste des category
    categoryList:Category[] = [];



    //L'event qui sera retourné au parent et informera sur l'etat  category
    @Output() categoryListOutput: EventEmitter<Category[]> = new EventEmitter<Category[]>();

    constructor(

      private _category: CategoryService,
      private fb:FormBuilder,
      private route : Router
      ) {  }

    //formulaire
    categoryForm!: FormGroup;

   ngOnInit(): void {
   //actualisation des category
     this.getallCategory();

   //add category
       this.categoryForm= this.fb.group({

        name : [``,Validators.required]

       });
   }

    // insertion des roles dans la bd
 onSubmit(){
  this._category.createCategory(this.categoryForm.value).subscribe({
    next:(response :any) =>{
      this.getallCategory();
    },
    error: error => {
      console.error("Erreur lors de l'enregistrement des category!", error);
    }
  })

console.log(this.categoryForm.value)

}



getallCategory(){

      this._category.getCategorys().subscribe({

        next: (response: any)=>{

          // affecte a categorylist la liste des roles venu de l'api
          this.categoryList = response as Category[];

          // affiche  dans la console la liste des category
          console.log(this.categoryList)

          //Renvoi de la liste au composant enfant
          this.categoryListOutput.emit(this.categoryList);


      },
          error: error => {
            console.error("Erreur lors de la recuperation des des informations  des categories!", error);
          }
        })

    }


}
