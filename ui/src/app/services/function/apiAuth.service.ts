import { environnement } from './../../environnements/environnement';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor (private _http: HttpClient){}

  post(parameter:  Required<{endpoint : string , data: any}>) {

    return this._http.post(`${environnement.BASE_URL}${parameter.endpoint}`,parameter.data, {headers: this.httpHeader()});

  }
  httpHeader() {
    return new HttpHeaders({

      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, PUT,DELETE',
      'Accept': 'application/json',

    });

}
}