import { Speciality } from "./speciality";

export interface  Doctor {

    id:number,

    first_name: string,

    last_name: string,

    address:string,

    email:string,

    phone_number: string,

    login:string,

    password:string,

    matricule: string,

    speciality: Speciality

}