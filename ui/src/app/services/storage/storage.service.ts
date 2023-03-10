import { Injectable } from "@angular/core";

@Injectable({
  providedIn : 'root'
})
export class StorageService {

  constructor(){

  }

  get(key : string) {
    return localStorage.getItem(key);
  }

  set(parameter : Required<{key : string , value : any}>) {
    localStorage.setItem(parameter.key, parameter.value);
  }

  delete(key : string ) {
    localStorage.removeItem(key);
  }
}
