--  insert data

select * from doctors

-- specialities
insert into specialities(name)
values('UROLOGIE'),
		('RHUMATOLOGIE'),
		('RADIOTHERAPIE'),
		('RADIOLOGIE'),
		('PSYCHIATRIE'),
		('PNEUMOLOGIE'),
		('PEDIATRIE'),
		('ORTHOPEDIE'),
		('OPHTAMOLOGIE'),
		('OBSTETRIQUE'),
		('ONCOLOGIE'),
		('ODONTOLOGIE'),
		('NEUROLOGIE'),
		('GENERALISTE'),
		('NEPHROLOGIE'),
		('NEONATOLOGIE'),
		('INFECTIOLOGIE'),
		('HEPATOLOGIE'),
		('HEMATOLOGIE'),
		('GYNECOLOGIE'),
		('GERIATRIE'),
		('GASTRO-ENTEROLOGIE'),
		('ENDOCRINOLOGIE'),
		('DERMATOLOGIE'),
		('ANDROLOGIE'),
		('CHIRUGIE-CARDIAQUE'),
		('CHIRUGIE-PLASTIQUE-ESTHETIQUE-RECONSTRUCTIVE'),
		('CHIRUGIE-GENERALE'),
		('CHIRUGIE-PADIATRIE'),
		('CHIRUGIE-THORACIQUE'),
		('CHIRUGIE-VASCULAIRE'),
		('NEUROCHIRURGIE'),
		('CARDIOLOGIE'),
		('ANESTHESOLOGIE'),
		('MEDECINE-DU-TRAVAIL'),
		('MEDECINE-DU-GENERALE'),
		('MEDECINE-DU-INTERNE'),
		('MEDECINE-DU-NUCLEAIRE'),
		('MEDECINE-DU-PALLIATIVE'),
		('MEDECINE-DU-PHIQUE'),
		('MEDECINE-DU-PREVENTIVE')
		
		
		

-- admin
insert into users (adresse,email,first_name,last_name,login,md_passe,phone_number,role_id)
values('yop','jean@gmail.com','akou','jean','akou01','akou01','+2250757336347',2)
	   
-- patient
insert into users (adresse,email,first_name,last_name,login,md_passe,phone_number,role_id)
values('yop','vivien@gmail.com','ndy','jean','ndy01','ndy01','+22501105781',1)

--  contry
 insert into contries (name)
 values('CIV');

 --  roles
 insert into roles (name)
 values ('Patient'),
		('Admin'),
		('Doctor'),
		('Hospital');
 
--  city
 insert into cities (name, contry_id)
 values('ABIDJAN',1),
 		('YAMOUSSOUKRO',1),
		('BOUAKE',1),
		('BONOUA',1),
		('DABOU',1),
		('MAN',1),
		('GRAND_BASSAM',1),
		('GRAND_LAHOU',1),
		('KORHOGO',1);
		
-- communes
 insert into municipalities (name, city_id)
 values('YOPOUGON',1),
 		('ABOBO',1),
		('ADJAME',1),
		('COCODY',1),
		('TREICHVILLE',1),
		('PLATEAU',1),
		('ANDOKOI',1),
		('BINGERVILLE',1),
		('RIVIERA',1)
--  category
 insert into etablissement_categories (category)
 values ('CHR'),
		('CHU'),
		('CLINIQUE'),
		('MATERNITE');
		
-- hopitaux
 insert into hospitals (name, municipality_id,category_id)
 values('MATERNITY ANONKOUA',(select id from municipalities where name ILIKE '%ABOBO%'),(select id from etablissement_categories where category ILIKE '%MATERNITE%')),
 	   ('LAOULO',(select id from municipalities where name ILIKE '%YOPOUGON%'),(select id from etablissement_categories where category ILIKE '%CLINIQUE%'));
		
		
		
select * from etablissement_categories
		
		
		
		
		
		