create table tbl_customers(id int primary key auto_increment,first_name varchar(50),
last_name varchar(50),email varchar(100),contact_no varchar(50),created_date timestamp default current_timestamp,
status boolean default true);

create table tbl_suppliers(id int primary key auto_increment,name varchar(50),email varchar(100),
contact_no varchar(50),contact_person varchar(100),address varchar(100),
created_date timestamp default current_timestamp,
status boolean default true);

create table tbl_users(id int primary key auto_increment,username varchar(50),
password varchar(50),email varchar(100),contact_no varchar(50),created_date timestamp default current_timestamp,
status boolean default true);

create table access_logs(id int primary key auto_increment,url varchar(50),
method varchar(50),agent varchar(100),ip varchar(50),created_date timestamp default current_timestamp);