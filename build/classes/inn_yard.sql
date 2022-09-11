
use inn_yard;

select *from login;

create table add_employee(name varchar(25), age varchar(10), gender varchar(15), job varchar(30), salary varchar(15), phone varchar(15), email varchar(40)); 

select *from add_employee; 

delete from add_employee where age = '';

create table add_rooms(room_num varchar(10), avalability varchar(20), status varchar(20), price varchar(20), bed_type varchar(20));

select *from add_rooms;

create table add_drivers(name varchar(50), age varchar(10), gender varchar(10), company varchar(50), brand varchar(50), availability varchar(15), location varchar(30));

select *from add_drivers;

create table add_customer(id varchar(30), number varchar(25), name varchar(35), gender varchar(10), country varchar(20), room_no varchar(15), time varchar(60), deposit varchar(30));

select *from add_customer;

create table department(department varchar(30), budget varchar(30));

insert into department values('Front Office', '500000 taka'),('Housekeeping','40000 taka'),('Food and beverage','23000 taka'),('Kichen or Food Production','540000 taka'),('Security','32000 taka');

select *from department;

delete add_customer where number='5678';













