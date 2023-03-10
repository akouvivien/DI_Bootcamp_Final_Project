import { httpService } from './../../../services/auth/auth.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup,Validators,FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent  {

registerForm!: FormGroup;

  constructor(
    private fb:FormBuilder,
     private httpService : httpService,
     private route : Router
  ){}

  ngOnInit(): void {

    this.registerForm= this.fb.group({

      email : [``,Validators.required,],

      password : [``,Validators.required],

      first_name : [``,Validators.required],

      last_name : [``,Validators.required],

      phone_number : '',

      login : [``,Validators.required ],

      adresse : [``,Validators.required],

    });
  }

  onSubmit(){
    this.httpService.register(this.registerForm.value).subscribe({
      next:(response :any) =>{

//TODO a gerer la redirection apres le temps definit

        //  setTimeout(() => {this.route.navigate(["/login"])}, 3000);

      }
 });

  console.log(this.registerForm.value)

}
}
