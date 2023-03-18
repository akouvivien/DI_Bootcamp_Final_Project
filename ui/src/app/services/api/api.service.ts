import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { HttpHeaders } from "@angular/common/http";
import { environnement } from './../../environnements/environnement';

@Injectable({
  providedIn : 'root'
})
export class HttpService {

  constructor(private http : HttpClient) {

  }

  get(endpoint : string ) {
    return this.http.get(`${environnement.BASE_URL}${endpoint}`,{headers : this.httpHeader()});
  }

  post(parameter : Required<{endpoint : string , data : any}> ) {
    return this.http.post(`${environnement.BASE_URL}${parameter.endpoint}`,parameter.data, {headers : this.httpHeader()} );
  }

  getId(parameter : Required<{endpoint : string , data : any}> ) {
    return this.http.post(`${environnement.BASE_URL}${parameter.endpoint}`,parameter.data, {headers : this.httpHeader()} );
  }

  put(parameter : Required<{endpoint : string ,data : any}>) {
    return this.http.put(`${environnement.BASE_URL}${parameter.endpoint}` ,parameter.data,{headers : this.httpHeader()});
  }

  delete(endpoint : string) {
    return this.http.delete(`${environnement.BASE_URL}${endpoint}`,{headers : this.httpHeader()});
  }


  httpHeader() {
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, PUT,DELETE',
      'Accept': 'application/json',
    });
  }



  /*request(request : IHttpData) {
    if(request.request == EHttpRequest.POST) {
    }
  } */
}
