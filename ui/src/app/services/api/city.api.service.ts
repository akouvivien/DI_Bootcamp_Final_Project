import { Injectable } from "@angular/core";
import { url_path } from "src/app/constant/constant";
import { HttpService } from "./api.service";
import { City } from "src/app/interfaces/city";



@Injectable({
  providedIn : 'root'
})

export class CityService {

  constructor(private httpService : HttpService ) {  }

  createCity(city : City) {
   return this.httpService.post({endpoint : url_path.CITY_BASE,data : city});
  }

  updateCity(city : City) {
    return this.httpService.put({endpoint : url_path.CITY_BASE,data : city});
  }

  getcities() {
   return this.httpService.get(url_path.CITY_BASE);
  }

  deleteCity(id : string) {
    return this.httpService.delete(`${url_path.CITY_BASE}/${id}`);
  }

}