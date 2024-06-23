//For execution of the OracleJDBCTeam2.java file
1. create nano OracleJDBCTeam2.java on omega
2. put the proper sqlplus username and password in the connectionn string 
3. compile the program using javac OracleJDBCTeam2.java
4. java OracleJDBCTeam2 ---- to see the output

//For output functionalities
In the output it will give different options to select one of them
1. To place an order
(modifies two relations Fall22_S003_2_Custoemr and Fall22_S003_2_Order)
2. To just see the menu
(retrievs the data from Fall22_S003_2_Order)
3. Customer IDs who have shown interest in giving rating
(uses fetch)
4. Customer IDs,Emails who have shown interest in ordering more than once
(uses group by and having)
5. Most frequently used Inventory Item IDs
(uses cube)
6. Customer ID, Name, Email who have opted for Dine-IN order type
(uses join and in)

//to see each of the functionality you need to execute the command
java OracleJDBCTeam2


