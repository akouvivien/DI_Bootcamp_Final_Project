import { Injectable } from "@angular/core";
import { url_path } from "src/app/constant/constant";
import { Assignements } from "src/app/interfaces/assignements";
import { Category } from "src/app/interfaces/category";
import { HttpService } from "./api.service";

@Injectable({
    providedIn : 'root'
  })
  
  export class AssignementService {
  
    constructor(private httpService : HttpService ) {  }
  
    createAssign(assignements : Assignements) {
     return this.httpService.post({endpoint : url_path.SPECIALITYHOSPITALDOC_BASE,data : assignements});
    }
  
    updateAssign(assignements : Category) {
      return this.httpService.put({endpoint : url_path.SPECIALITYHOSPITALDOC_BASE,data : assignements});
    }
  
    getAssigns() {
     return this.httpService.get(url_path.SPECIALITYHOSPITALDOC_BASE);
    }
  
    deleteAssign(id : string) {
      return this.httpService.delete(`${url_path.SPECIALITYHOSPITALDOC_BASE}/${id}`);
    }
  
  }