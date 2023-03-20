import { Category } from 'src/app/interfaces/category';
import { Municipality } from './municipality';
export interface Hospital {
  id : number,
  name : string
  adresse: string,
  municipalityId:Municipality,
  etablissementCategoryId:Category
}
