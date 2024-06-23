-----------------INVENTORY TABLE STARTS HERE------------------------------
CREATE TABLE Fall22_S003_2_Inventory(
item_id varchar(5),
item_name varchar(100) not null,
mfd_date date not null,
expiry_date date not null,
date_purchased date not null,
qty_purchased number(8,4) not null,
item_price number(8,4) not null,
qty_left_for_day number(8,4),
primary key(item_id));
-----------------INVENTORY TABLE ENDS HERE------------------------------

-----------------EMPLOYEE TABLE STARTS HERE------------------------------
CREATE TABLE Fall22_S003_2_Employee(
eid number(10) primary key,
f_name varchar(60) not null,
m_name varchar(60),
l_name varchar(60) not null,
gender char(1) not null,
dob date not null,
salary number(8,2) not null,
phone# number(10) not null,
supID number(10),
imgrID number(10),
foreign key(supID) references Fall22_S003_2_Employee(eid) on delete cascade,
foreign key(imgrID) references Fall22_S003_2_Employee(eid) on delete cascade);
-----------------EMPLOYEE TABLE ENDS HERE------------------------------

------------------DEPARTMENT TABLE STARTS HERE------------------------------
CREATE TABLE Fall22_S003_2_Department(
dept_ID number(2) primary key,
dept_name varchar(60) not null,
mgrID number(10) not null,
start_date date not null,
foreign key(mgrID) references Fall22_S003_2_Employee(eid) on delete cascade);
-----------------DEPARTMENT TABLE ENDS HERE-------------------------------------

------------------DEPARTMENT AND EMPLOYEE TABLE STARTS HERE------------------------------
CREATE TABLE Fall22_S003_2_Dept_Emp(
eid number(10),
DeptId number(10),
primary key(eid,DeptId),
foreign key(eid) references Fall22_S003_2_Employee(eid) on delete cascade,
foreign key(DeptID) references Fall22_S003_2_Department(dept_ID) on delete cascade);
-----------------DEPARTMENT AND EMPLOYEE TABLE ENDS HERE-------------------------------------

-----------------EMPLOYEE_ADD_ZIPCODE TABLE STARTS HERE------------------------------
CREATE TABLE Fall22_S003_2_Employee_Add_Zipcode(
zipcode number(10) unique,
city varchar(30),
primary key(zipcode,city));
-----------------EMPLOYEE_ADD_ZIPCODE TABLE ENDS HERE------------------------------

-----------------EMPLOYEE_ADDRESS TABLE STARTS HERE------------------------------
CREATE TABLE Fall22_S003_2_Employee_Address(
eid number(10),
zipcode number(10),
street varchar(30),
primary key(eid,zipcode,street),
foreign key(zipcode) references Fall22_S003_2_Employee_Add_Zipcode(zipcode) on delete cascade,
foreign key(eid) references Fall22_S003_2_Employee(eid) on delete cascade);
-----------------EMPLOYEE_ADDRESS TABLE ENDS HERE--------------------------------

-----------------EMPLOYEE_EMAIL TABLE STARTS HERE------------------------------
CREATE TABLE Fall22_S003_2_Employee_Email(
eid number(10),
email varchar(50),
primary key(eid,email),
foreign key(eid) references Fall22_S003_2_Employee(eid) on delete cascade);
-----------------EMPLOYEE_EMAIL TABLE ENDS HERE------------------------------

-----------------CUSTOMER TABLE STARTS HERE------------------------------
CREATE TABLE Fall22_S003_2_Customer(
cid number(15) primary key,
email varchar(50) not null,
phone# number(10) not null,
age number(3) not null,
f_name varchar(60) not null,
l_name varchar(60) not null,
gender char(1) not null);
-----------------CUSTOMER TABLE ENDS HERE------------------------------

-----------------ORDER TABLE STARTS HERE------------------------------
CREATE TABLE Fall22_S003_2_Order(
id number(5) primary key,
orderCategory varchar(30) not null,
type varchar(30) not null,
price number(5,2) not null,
order_taken_time varchar(30) not null,
order_served_time varchar(30) not null,
cid number(10) not null,
eid number(10) not null,
item_id_used varchar(20) not null,
foreign key(item_id_used) references Fall22_S003_2_Inventory(item_id) on delete cascade,
foreign key(cid) references Fall22_S003_2_Customer(cid) on delete cascade,
foreign key(eid) references Fall22_S003_2_Employee(eid) on delete cascade);
-----------------ORDER TABLE ENDS HERE------------------------------

-----------------SUPPLIER TABLE STARTS HERE------------------------------
CREATE TABLE Fall22_S003_2_Supplier(
sid number(10),
name varchar(100) not null,
primary key(sid));
-----------------SUPPLIER TABLE ENDS HERE------------------------------

-----------------SUPPLIES TABLE STARTS HERE------------------------------
CREATE TABLE Fall22_S003_2_Supplies(
sid number(10),
item_id varchar(20),
primary key(sid,item_id),
foreign key(item_id) references Fall22_S003_2_Inventory(item_id) on delete cascade,
foreign key(sid) references Fall22_S003_2_Supplier(sid) on delete cascade);
-----------------SUPPLIES TABLE ENDS HERE------------------------------

-----------------DAILY_SCHEDULE TABLE STARTS HERE------------------------------
CREATE TABLE Fall22_S003_2_Daily_Schedule(
schedule_id number(10),
start_time varchar(10) not null,
end_time varchar(10) not null,
task varchar(100) not null,
eid number(10),
primary key(schedule_id, eid),
foreign key(eid) references Fall22_S003_2_Employee(eid) on delete cascade);
-----------------DAILY_SCHEDULE TABLE ENDS HERE------------------------------

-----------------FEEDBACK TABLE STARTS HERE------------------------------
CREATE TABLE Fall22_S003_2_Feedback(
order_id number(10),
suggestion varchar(100),
complaint varchar(100),
rating number(2),
cid number(10),
primary key(order_id, cid),
foreign key(cid) references Fall22_S003_2_Customer(cid) on delete cascade);
-----------------FEEDBACK TABLE ENDS HERE------------------------------

-----------------GENERATE_RECEIPT TABLE STARTS HERE------------------------------
CREATE TABLE Fall22_S003_2_Generate_Receipt(
receipt_id number(13),
eid number(10),
cid number(10),
primary key(receipt_id),
foreign key(eid) references Fall22_S003_2_Employee(eid),
foreign key(cid) references Fall22_S003_2_Customer(cid) on delete cascade);
-----------------GENERATE_RECEIPT TABLE ENDS HERE------------------------------
