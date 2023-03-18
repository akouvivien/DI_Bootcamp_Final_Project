import { Injectable } from "@angular/core";
import { HttpService } from "./api.service";
import { Doctor } from 'src/app/interfaces/doctor';
import { url_path } from "src/app/constant/constant";

@Injectable({
  providedIn : 'root'
})
export class DoctorService {

  constructor(private httpService : HttpService ) {  }

  createDoctor(doctor : Doctor) {
   return this.httpService.post({endpoint : url_path.DOCTOR_BASE,data : doctor});
  }

  updateDoctor(doctor : Doctor) {
    return this.httpService.put({endpoint : url_path.DOCTOR_BASE,data : doctor});
  }

  getDoctors() {
   return this.httpService.get(url_path.DOCTOR_BASE);
  }

  deleteDoctor(id : number) {
    return this.httpService.delete(`${url_path.DOCTOR_BASE}/${id}`);
  }

}