import { Injectable } from '@angular/core';
import { url_path } from 'src/app/constant/constant';
import { Contry } from './../../interfaces/contry';
import { HttpService } from './api.service';


@Injectable({
  providedIn : 'root'
})

export class ContryService {

  constructor(private httpService : HttpService ) {  }

  createContry(Contry : Contry) {
   return this.httpService.post({endpoint : url_path.CONTRY_BASE,data : Contry});
  }

  updateContry(Contry : Contry) {
    return this.httpService.put({endpoint : url_path.CONTRY_BASE,data : Contry});
  }

  getContries() {
   return this.httpService.get(url_path.CONTRY_BASE);
  }

  deleteContry(id : string) {
    return this.httpService.delete(`${url_path.CONTRY_BASE}/${id}`);
  }

}