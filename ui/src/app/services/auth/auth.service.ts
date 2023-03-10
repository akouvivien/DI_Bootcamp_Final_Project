import { Injectable } from '@angular/core';
import { User } from 'src/app/interfaces/user';
import { url_path } from 'src/app/constant/constant';
import { HttpService } from '../api/api.service';

@Injectable({
  providedIn: 'root'
})
export class httpService {

  constructor( private _authService: HttpService) { }

  login(user : User){

    return this._authService.post({endpoint : url_path.AUTH_LOGIN, data : user});
  }

  register(user : User){

    return this._authService.post({endpoint : url_path.AUTH_REGISTER, data : user});
  }

}
