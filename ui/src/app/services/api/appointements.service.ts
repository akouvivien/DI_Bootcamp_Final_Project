import { Injectable } from '@angular/core';
import { url_path } from 'src/app/constant/constant';
import { Appointements } from './../../interfaces/appointements';
import { HttpService } from './api.service';


@Injectable({
  providedIn : 'root'
})

export class AppointementService {

  constructor(private httpService : HttpService ) {  }

  createAppointement(appointement : Appointements) {
   return this.httpService.post({endpoint : url_path.APPOINTEMENTS_BASE,data : appointement});
  }

  updateAppointement(appointement : Appointements) {
    return this.httpService.put({endpoint : url_path.APPOINTEMENTS_BASE,data : appointement});
  }
 
  getAppointements() {
   return this.httpService.get(url_path.APPOINTEMENTS_BASE);
  }

  deleteAppointement(id : string) {
    return this.httpService.delete(`${url_path.APPOINTEMENTS_BASE}/${id}`);
  }


  ShearchByPatient(appointement : Appointements) {
    return this.httpService.post({endpoint :  url_path.APPOINTEMENTS_PATIENT,data : appointement});
   }


   ShearchByPatientAndHospital(appointement : Appointements) {
    return this.httpService.post({endpoint :  url_path.APPOINTEMENTS_PATIENT_HOSPITAL,data : appointement});
   }

   ShearchByHospital(appointement : Appointements) {
    return this.httpService.post({endpoint :  url_path.APPOINTEMENTS_HOSPITAL,data : appointement});
   }

}