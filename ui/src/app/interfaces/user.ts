import { Roles } from "./roles";

export interface User {
  id : number,

   email : string,

   password : string,

   first_name : string,

   last_name : string,

   phone_number : string,

   login : string ,

   adresse : string,

   roles: Roles

}
