import { Injectable } from "@angular/core";
import { url_path } from "src/app/constant/constant";
import { Roles } from "src/app/interfaces/roles";
import { HttpService } from "./api.service";

@Injectable({
  providedIn : 'root'
})

export class RolesService {

  constructor(private httpService : HttpService ) {  }

  createRole(roles : Roles) {
   return this.httpService.post({endpoint : url_path.ROLE_BASE,data : roles});
  }

  updateRole(roles : Roles) {
    return this.httpService.put({endpoint : url_path.ROLE_BASE,data : roles});
  }

  getRoles() {
   return this.httpService.get(url_path.ROLE_BASE);
  }

  deleteRole(id : number) {
    return this.httpService.delete(`${url_path.ROLE_BASE}/${id}`);
  }

}