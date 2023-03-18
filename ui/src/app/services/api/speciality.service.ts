import { Injectable } from "@angular/core";
import { url_path } from "src/app/constant/constant";
import { Speciality } from "src/app/interfaces/speciality";
import { HttpService } from "./api.service";


@Injectable({
  providedIn : 'root'
})

export class SpecialityService {

  constructor(private httpService : HttpService ) {  }

  createSpeciality(speciality : Speciality) {
   return this.httpService.post({endpoint : url_path.SPECIALITY_BASE,data : speciality});
  }

  updateSpeciality(speciality : Speciality) {
    return this.httpService.put({endpoint : url_path.SPECIALITY_BASE,data : speciality});
  }

  getSpeciality() {
   return this.httpService.get(url_path.SPECIALITY_BASE);
  }

  deleteSpeciality(id : number) {
    return this.httpService.delete(`${url_path.SPECIALITY_BASE}/${id}`);
  }

  

}