-------- to check effects on employee,order and feedback these updates are done----
update Fall22_S003_2_Employee set salary=3000 where eid=1232527;
update Fall22_S003_2_Employee set supID=Null,imgrID=Null where eid=1040594;
delete from Fall22_S003_2_Employee where eid=1407142;
update Fall22_S003_2_Employee set supID= null,imgrID=null,salary=4000
where eid=1515560;

update Fall22_S003_2_Order set type='to_go' where id=2385;
update Fall22_S003_2_Order set type='to_go' where id = 1323;
update Fall22_S003_2_Order set type='dine_in' where id=2084;

update Fall22_S003_2_Feedback set rating=4 where order_id=1134;
update Fall22_S003_2_Feedback set rating=2 where order_id=987;
update Fall22_S003_2_Feedback set rating=3 where order_id=844;
delete from Fall22_S003_2_Order where id=2375;


update Fall22_S003_2_Employee_Add_Zipcode set city='Grand Prairie' where
zipcode=75011;