import { Injectable } from "@angular/core";
import { url_path } from "src/app/constant/constant";
import { HospitalDoctor } from "src/app/interfaces/hospitaldoctor";
import { HospitalSpeciality } from "src/app/interfaces/hospitalspeciality";
import { HttpService } from "./api.service";

@Injectable({
  providedIn : 'root'
})

export class HospitalDoctorService {

  constructor(private httpService : HttpService ) {  }

  AssignHospitalDoctor(hospitalspeciality : HospitalDoctor) {
   return this.httpService.post({endpoint : url_path.HOSPITALDOCTOR_BASE,data : hospitalspeciality});
  }

  updateHospitalDoctor(hospitalspeciality : HospitalDoctor) {
    return this.httpService.put({endpoint : url_path.HOSPITALDOCTOR_BASE,data : hospitalspeciality});
  }

  getHospitalDoctor() {
   return this.httpService.get(url_path.HOSPITALDOCTOR_BASE);
  }

  deleteHospitalDoctor(id : number) {
    return this.httpService.delete(`${url_path.HOSPITALDOCTOR_BASE}/${id}`);
  }


  shearchByHospital(hospitalspeciality : HospitalSpeciality) {
    return this.httpService.post({endpoint : url_path.HOSPITALDOCTOR_HOSPITAL,data : hospitalspeciality});
   }

   shearchByDoctor(hospitalspeciality : HospitalSpeciality) {
    return this.httpService.post({endpoint : url_path.HOSPITALDOCTOR_DOCTOR,data : hospitalspeciality});
   }

}