use taskmanager;


create table languages(id int primary key auto_increment,language varchar(20));

create table EmployeeData(
ID int primary key auto_increment,
fullName varchar(30),
email varchar(30),
phone varchar(15),
languageID int,
upassword varchar(30),
dateOfJoin date,
job varchar(10),
foreign key (languageID) references languages(id)
);

create table WeaklyReport(
id int primary key auto_increment,
employeeID int,
createdDate date,
title varchar(50),
report varchar(1500),
foreign key (employeeID) references EmployeeData(id)
);

create table projects(
id int primary key auto_increment,
name varchar(30),
languageID int, 
discription varchar(500),
deadLine date,
foreign key (languageID) references languages(id)
);

create table employeeTask(
id int primary key auto_increment,
projectID int,
employeeID int,
deadLine date,
completedTime date,
discription varchar(500),
filepath varchar(100),
foreign key (employeeID) references EmployeeData(id),
foreign key (projectID) references projects(id)
);


 create table Replay(
 id int primary key auto_increment,
 ReportId int,
 employeeId int,
 replay varchar(500),
 seen bool,
 createdDate date,
 foreign key (ReportId) references employeeTask(id),
 foreign key (employeeId) references EmployeeData(id)
 );


drop table projects;
drop table languages;
drop table employeeTask;
drop table EmployeeData;


insert into languages(language) values('JAVA');
insert into languages(language) values('PYTHON');
insert into languages(language) values('ANDROID');
insert into languages(language) values('PHP');
insert into languages(id,language) value(999,'HR');

insert into EmployeeData(fullName,email,phone,languageID,upassword,dateOfJoin,job) values('jerin','jerin@g.com','12121212',1,'mypass','2019-07-07','normal');
insert into EmployeeData(fullName,email,phone,languageID,upassword,dateOfJoin,job) values('hr','hr@g.com','12121212',1,'pass','2019-07-07','HR');

insert into projects(name,languageID, discription,deadLine) values('Online DataStorage',1,'encripted files','2019-08-08');
insert into employeeTask(projectID,employeeID,deadLine,discription,filepath) values(1,1,'2019-10-10','login','files/a.txt');