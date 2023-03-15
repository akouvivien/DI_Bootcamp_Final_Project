import { Component, Input } from '@angular/core';
import { Category } from 'src/app/interfaces/category';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent {

  @Input() categoryList!:Category[];

}
