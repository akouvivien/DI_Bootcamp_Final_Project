import { StorageService } from './storage.service';
import { User } from "src/app/interfaces/user";
import { Injectable } from '@angular/core';
import { environnement } from 'src/app/environnements/environnement';

@Injectable({
  providedIn :'root'
})

export class UserService {

  User !: User;

  constructor(private storageService : StorageService ){
    this.User = JSON.parse(this.storageService.get(environnement.APIKEY) as string);
  }

  logout(){
    this.storageService.delete(environnement.APIKEY);
  }

  isConnected() : boolean {
    return !!this.User;
  }

  getUser() : User{
   return this.User as User;
  }

}
