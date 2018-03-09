BEGIN TRANSACTION;


CREATE TABLE IF NOT EXISTS `Expenses` (
	`eid`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`bid`	INTEGER NOT NULL,
	`eyear`	TEXT NOT NULL,
	`emonth`	TEXT NOT NULL,
	`electric`	INTEGER NOT NULL,
	`water`	INTEGER NOT NULL,
	`cleaning`	INTEGER NOT NULL,
	`other_shared_expenses`	INTEGER NOT NULL,
	`gus`	INTEGER NOT NULL,
	`boiler_maintenance`	INTEGER NOT NULL,
	`joint_ownership`	INTEGER NOT NULL,
	`elevator_maintenance`	INTEGER NOT NULL,
	`elevator_spare_parts`	INTEGER NOT NULL,
	`elevator_technician`	INTEGER NOT NULL
);

INSERT INTO `Expenses` (eid,bid,eyear,emonth,electric,water,cleaning,other_shared_expenses,gus,boiler_maintenance,joint_ownership,elevator_maintenance,elevator_spare_parts,elevator_technician) VALUES (1,2,'2018','01',10,20,30,40,50,60,70,80,90,100),
 (2,2,'2018','02',25,50,75,100,125,150,175,200,225,250);
 
 
CREATE TABLE IF NOT EXISTS `Apartments` (
	`aid`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`bid`	INTEGER NOT NULL,
	`atype`	TEXT NOT NULL,
	`floor`	INTEGER NOT NULL,
	`sq_meters`	INTEGER NOT NULL,
	`owner_fname`	TEXT NOT NULL,
	`owner_lname`	TEXT NOT NULL,
	`owner_phone`	TEXT NOT NULL,
	`amonth`	TEXT NOT NULL,
	`ayear`	TEXT NOT NULL,
	`aname`	TEXT NOT NULL
);

INSERT INTO `Apartments` (aid,bid,atype,floor,sq_meters,owner_fname,owner_lname,owner_phone,amonth,ayear,aname) VALUES (1,2,'Διαμέρισμα',0,100,'Νίκος','Σερέτης','6949887766','04','2015','Α1'),
 (2,2,'Κατάστημα',0,100,'Σπύρος','Παπαδόπουλος','6977112233','04','2015','Α2'),
 (3,2,'Διαμέρισμα',1,120,'Κατερίνα','Παπανικολάου','6933998844','02','2017','Β1'),
 (4,2,'Διαμέρισμα',1,80,'Μιχάλης','Καραφώτης','2231077189','09','2017','Β2');
 
 
CREATE TABLE IF NOT EXISTS `ApBuildings` (
	`bid`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`address`	TEXT NOT NULL,
	`city`	TEXT NOT NULL,
	`addr_code`	TEXT NOT NULL,
	`building_admin_fname`	TEXT NOT NULL,
	`building_admin_lname`	TEXT NOT NULL,
	`num_of_floors`	INTEGER NOT NULL,
	`sq_meters_per_floor`	INTEGER NOT NULL,
	`num_of_apartments`	INTEGER NOT NULL,
	`bmonth`	TEXT NOT NULL,
	`byear`	TEXT NOT NULL
);

INSERT INTO `ApBuildings` (bid,address,city,addr_code,building_admin_fname,building_admin_lname,num_of_floors,sq_meters_per_floor,num_of_apartments,bmonth,byear) VALUES (1,'Μάρκου Μπότσαρη 49','Λαμία','35100','Γιώργος','Καρδάτος',3,120,6,'04','2015'),
 (2,'Αθηνών 117','Λαμία','35100','Χρήστος','Ζερβός',2,200,4,'07','2013');
 
 
COMMIT;
