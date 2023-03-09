import { Injectable } from '@angular/core';
import { AuthService } from '../function/apiAuth.service';
import { User } from 'src/app/interfaces/user';
import { url_path } from 'src/app/constant/constant';

@Injectable({
  providedIn: 'root'
})
export class httpService {

  constructor( private _authService: AuthService) { }

  login(user : User){

    return this._authService.post({endpoint : url_path.AUTH_LOGIN, data : user});
  }

  register(user : User){
    
    return this._authService.post({endpoint : url_path.AUTH_REGISTER, data : user});
  }

}
