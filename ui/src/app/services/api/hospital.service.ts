import { url_path } from 'src/app/constant/constant';
import { Hospital } from './../../interfaces/hospital';
import { HttpService } from "./api.service";


@Injectable({
  providedIn : 'root'
})

export class HospitalService {

  constructor(private httpService : HttpService ) {  }

  createHospital(hospital : Hospital) {
   return this.httpService.post({endpoint : url_path.HOSPITAL_BASE,data : hospital});
  }

  updateHospital(hospital : Hospital) {
    return this.httpService.put({endpoint : url_path.HOSPITAL_BASE,data : hospital});
  }

  getHospitals() {
   return this.httpService.get(url_path.DOCTOR_BASE);
  }

  deleteHospital(id : string) {
    return this.httpService.delete(`${url_path.DOCTOR_BASE}/${id}`);
  }

}


