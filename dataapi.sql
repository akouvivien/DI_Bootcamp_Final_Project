--  insert data
--  contry
 insert into contries (name)
 values('CIV');
 
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
 insert into etablissement_categories (name)
 values ('CHR'),
		('CHU'),
		('CLINIQUE'),
		('MATERNITE');
		
-- hopitaux
 insert into hospitals (name, municipality_id,category_id,status)
 values('MATERNITY ANONKOUA',(select id from municipalities where name ILIKE '%ABOBO%'),(select id from etablissement_categories where name ILIKE '%MATERNITE%'),'true'),
 	   ('LAOULO',(select id from municipalities where name ILIKE '%YOPOUGON%'),(select id from etablissement_categories where name ILIKE '%CLINIQUE%'),'false');
		
		
		
select * from etablissement_categories
		
		
		
		
		
		