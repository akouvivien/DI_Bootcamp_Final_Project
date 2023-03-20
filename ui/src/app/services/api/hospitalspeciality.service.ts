import { Injectable } from "@angular/core";
import { HospitalSpeciality } from "src/app/interfaces/hospitalspeciality";
import { HttpService } from "./api.service";
import { url_path } from "src/app/constant/constant";



@Injectable({
  providedIn : 'root'
})

export class HospitalSpecialityService {

  constructor(private httpService : HttpService ) {  }

  AssignHospitalSpeciality(hospitalspeciality : HospitalSpeciality) {
   return this.httpService.post({endpoint : url_path.HOSPITALSPECIALITY_BASE,data : hospitalspeciality});
  }

  updateHospitalSpeciality(hospitalspeciality : HospitalSpeciality) {
    return this.httpService.put({endpoint : url_path.HOSPITALSPECIALITY_BASE,data : hospitalspeciality});
  }

  getHospitalSpeciality() {
   return this.httpService.get(url_path.HOSPITALSPECIALITY_BASE);
  }

  deleteHospitalSpeciality(id : number) {
    return this.httpService.delete(`${url_path.HOSPITALSPECIALITY_BASE}/${id}`);
  }


  shearchByHospital(hospitalspeciality : HospitalSpeciality) {
    return this.httpService.post({endpoint : url_path.HOSPITALSPECIALITY_HOSPITAL,data : hospitalspeciality});
   }

   shearchBySpeciality(hospitalspeciality : HospitalSpeciality) {
    return this.httpService.post({endpoint : url_path.HOSPITALSPECIALITY_SPECIALITY,data : hospitalspeciality});
   }

}