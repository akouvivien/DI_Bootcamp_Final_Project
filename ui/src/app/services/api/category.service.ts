import { Injectable } from '@angular/core';
import { url_path } from 'src/app/constant/constant';
import { Category } from './../../interfaces/category';
import { HttpService } from './api.service';

@Injectable({
  providedIn : 'root'
})

export class CategoryService {

  constructor(private httpService : HttpService ) {  }

  createCategory(category : Category) {
   return this.httpService.post({endpoint : url_path.CATEGORY_BASE,data : category});
  }

  updateCategory(category : Category) {
    return this.httpService.put({endpoint : url_path.CATEGORY_BASE,data : category});
  }

  getCategorys() {
   return this.httpService.get(url_path.CATEGORY_BASE);
  }

  deleteCategory(id : string) {
    return this.httpService.delete(`${url_path.CATEGORY_BASE}/${id}`);
  }

}