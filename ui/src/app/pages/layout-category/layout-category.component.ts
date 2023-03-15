import { Component } from '@angular/core';
import { Category } from 'src/app/interfaces/category';

@Component({
  selector: 'app-layout-category',
  templateUrl: './layout-category.component.html',
  styleUrls: ['./layout-category.component.css']
})
export class LayoutCategoryComponent {

  categoryList : Category[] = [];

  ngOnInit() {
    this.categoryList
  }


  getCategoryListFromCategoryComponent(event: Category[]) {
    this.categoryList = event;
  }


}
