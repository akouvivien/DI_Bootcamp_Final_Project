import { httpService } from './../../../services/auth/auth.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup , Validators} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;


  constructor(
    private fb:FormBuilder,
    private httpService : httpService,
    private route : Router
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

  //TODO a gerer la redirection apres le temps definit

          setTimeout(() => {this.route.navigate(["/register"])}, 3000);

        }
    });
    console.log(this.loginForm.value)

  }

}
