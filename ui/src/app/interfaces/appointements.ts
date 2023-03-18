import { Hospital } from './hospital';
import { Patient } from './patient';
import { Speciality } from './speciality';

export interface Appointements {
   id : number,

   hospital : Hospital,

   patient : Patient,

   speciality : Speciality,

   date : string

}
