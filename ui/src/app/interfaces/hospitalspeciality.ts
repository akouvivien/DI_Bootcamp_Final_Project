import { Hospital } from './hospital';
import { Speciality } from './speciality';

export interface HospitalSpeciality{
  id : number,
  speciality: Speciality,
  hospital : Hospital
}