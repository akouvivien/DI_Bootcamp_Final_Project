export const url_path = {

  //authentification
  AUTH_LOGIN : 'auth/login',

  AUTH_REGISTER : 'auth/register',

  //doctor
  DOCTOR_BASE:'doctor',
  
  DOCTOR_SPECIALITY:'getbyspeciality',

  //patient
  PATIENT_BASE:'patient',

  //hospital
  HOSPITAL_BASE:'hospital',

  //speciality
  SPECIALITY_BASE:'speciality',

  //contry
  CONTRY_BASE:'contry',

  //city
  CITY_BASE:'city',

  //municipality
  MUNICIPALITY_BASE:'municipality',

  //category etablissement
  CATEGORY_BASE:'category',

  // roles
  ROLE_BASE:'roles',

  //appointements ou prise de rendez vous
  APPOINTEMENTS_BASE:'appointements',

  //appointements ou prise de rendez vous en fonction du patient
  APPOINTEMENTS_PATIENT:'appointements/getpatient',

  //appointements ou prise de rendez vous en fonction du patient et de l'hopital
  APPOINTEMENTS_PATIENT_HOSPITAL:'appointements/get',

  //appointements ou prise de rendez vous en fonction du doctor
  APPOINTEMENTS_HOSPITAL: 'appointements/gethospital',

//***********relation hopital et specialité */

    //assignation de specialité a un hopital 
    HOSPITALSPECIALITY_BASE:'hospitalspeciality',

    //recherche des hoptiaux par specialités
    HOSPITALSPECIALITY_SPECIALITY:'hospitalspeciality/getbyspeciality',


    //recherche des hoptiaux par selon les hopitaux
    HOSPITALSPECIALITY_HOSPITAL:'hospitalspeciality/getbyhospitals',


    //***********relation hopital et doctor */

    
    //relation hopital doctor
    HOSPITALDOCTOR_BASE:'hospitaldoctor',

    //recherche des hoptiaux par selon les hopitaux
    HOSPITALDOCTOR_HOSPITAL:'hospitalspeciality/getbyhospitals',


    //recherche des hoptiaux par selon les doctors
    HOSPITALDOCTOR_DOCTOR:'hospitalspeciality/getbydoctor',


    ///***********relation hopital docteur et specialité */


  //recherche sur la liasion entre hopital docteur et specialité  
  SPECIALITYHOSPITALDOC_BASE:'specialityhospitaldoctor'






}
