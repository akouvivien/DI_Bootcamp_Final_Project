import { httpService } from './../../../services/auth/auth.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup , Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/interfaces/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;

  users! : User


  constructor(
    private fb:FormBuilder,
    private httpService : httpService,
    private route : Router
    // private _save : StorageService
  ){}


  ngOnInit(): void {

    this.loginForm= this.fb.group({

      login : [``,Validators.required],

      password : [``,Validators.required]

      });
    }

    onSubmit(){
      this.httpService.login(this.loginForm.value).subscribe({
        next:(response :any) =>{

          this.users = response as User;

          console.log(this.users)

        // redirige vers la page principale
        setTimeout(() => {this.route.navigate(["/layout"])}, 3000);

        },
        error: error => {

          console.error("Erreur lors de la recuperation des des informations !", error);

        }

    });



  }

}
