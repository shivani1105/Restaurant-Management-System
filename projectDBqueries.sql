---1. Retreive the average salary of employee along with employee id, name, and gender-----
-----based on the gender of the employee who is a supervisor.--------------

select eid,f_name,gender,avg(salary) over (partition by gender) from
Fall22_S003_2_Employee where eid IN (select supID from
Fall22_S003_2_Employee);





--2. Retreive the customer name, id and email who have opted for ‘dine in’ order type -------
-----with a feedback rating of 7 and above-------------------

select cid,f_name,email from Fall22_S003_2_Customer where cid in(
select cid from Fall22_S003_2_Order where type='dine_in' and cid
in ( select o.cid from Fall22_S003_2_Order o join
Fall22_S003_2_Feedback f on o.cid=f.cid where f.rating>=7));




-----3. Retrieve id, name, and salary of employees who are from ‘Grand Prairie’ ------
------and have worked for more than 2 hours with total salary greater than 2000$.-----------
 
select eid,f_name,salary from Fall22_S003_2_Employee where eid in (
select eid from Fall22_S003_2_Employee_ADD_Zipcode where
city = 'Grand Prairie' and eid in (select eid from
Fall22_S003_2_Daily_Schedule where (end_time-start_time)/100 < 2 group
by eid having Fall22_S003_2_Employee.salary >2000));




---------------------4. Retrieve the supplier id, and the total number of items ---------
----------that it supplies to the inventory of the restaurant using ROLLUP----------------------------------

select s.sid,count(s.item_id) from Fall22_S003_2_Supplies s inner join Fall22_S003_2_Inventory i on i.item_id=s.item_id group by rollup(s.sid);


 

----------------------5. Retrieve the item id and the number of orders in which ------
-----------that item has been used using CUBE---------------------------------------------------

select o.item_id_used,count(o.id) from Fall22_S003_2_Order o inner join Fall22_S003_2_Supplies s on o.item_id_used=s.item_id group by cube(o.item_id_used);



-------------------------6.Retrieve the full name of the employee anlong -------
-----------with the count of emails that employee has-----------------------------------

select concat(concat(concat(concat(f_name,' '),m_name),' '),l_name) as FullName,(select count(e.email) from Fall22_S003_2_Employee_Email e where
e.eid=emp.eid) as EmailCount from Fall22_S003_2_Employee emp;



------------------7. Fetch first 5 customer ids and the number of times he/she --------
---------gave the rating from feedback ordered by the rating count---------------------------------

select cid,count(rating) as Count_of_Ratings from Fall22_S003_2_Feedback group by cid order by Count_of_Ratings desc fetch first 5 rows only;




--------------8. Retrieve the employee id and salary who has ---------
----------more than one street address that has north in it------------------------------------

select eid,salary from Fall22_S003_2_Employee where eid in (select eid from Fall22_S003_2_Employee_Address where street LIKE '%north%' group by eid
having count(*)>=1);

-----------9. Retrieve customer id and email -----------
------------who has ordered more than once---------------------

select cid,email from Fall22_S003_2_Customer where cid in (select cid from Fall22_S003_2_Order group by cid having count(*)>1);

 
