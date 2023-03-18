import { Category } from 'src/app/interfaces/category';
import { Municipality } from './municipality';
export interface Hospital {
  id : number,
  name : string
  adresse: string,
  status:boolean,
  municipality:Municipality,
  etablissementCategoryId:Category
}
