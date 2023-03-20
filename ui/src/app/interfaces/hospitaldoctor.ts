import { Doctor } from "./doctor";
import { Hospital } from "./hospital";

export interface HospitalDoctor {
  id : number,
  doctor : Doctor,
  hospital : Hospital
}
