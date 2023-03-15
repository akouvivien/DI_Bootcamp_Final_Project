import { url_path } from "src/app/constant/constant";
import { Patient } from "src/app/interfaces/patient";
import { HttpService } from "./api.service";
import { Injectable } from "@angular/core";


@Injectable({
  providedIn : 'root'
})
export class PatientService {

  constructor(private httpService : HttpService ) {  }

  createPatient(patient : Patient) {
   return this.httpService.post({endpoint : url_path.PATIENT_BASE,data : patient});
  }

  updatePatient(patient : Patient) {
    return this.httpService.put({endpoint : url_path.PATIENT_BASE,data : patient});
  }

  getPatients() {
   return this.httpService.get(url_path.PATIENT_BASE);
  }

  deletePatient(id : string) {
    return this.httpService.delete(`${url_path.PATIENT_BASE}/${id}`);
  }

}
