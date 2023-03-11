import { Injectable } from "@angular/core";
import { url_path } from "src/app/constant/constant";
import { HttpService } from "./api.service";
import { Municipality } from "src/app/interfaces/municipality";



@Injectable({
  providedIn : 'root'
})

export class MunicipalityService {

  constructor(private httpService : HttpService ) {  }

  createMunicipality(municipality : Municipality) {
   return this.httpService.post({endpoint : url_path.MUNICIPALITY_BASE,data : municipality});
  }

  updateMunicipality(municipality : Municipality) {
    return this.httpService.put({endpoint : url_path.MUNICIPALITY_BASE,data : municipality});
  }

  getMunicipalies() {
   return this.httpService.get(url_path.MUNICIPALITY_BASE);
  }

  deleteHospital(id : string) {
    return this.httpService.delete(`${url_path.MUNICIPALITY_BASE}/${id}`);
  }

}