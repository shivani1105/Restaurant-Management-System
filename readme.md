# Restaurant Management System (RMS)

## Project Learning and Objectives
This project was part of my coursework on Database Management Systems (DBMS), where I gained hands-on experience in building a database application with a user-focused approach. Through this project, I developed a deeper understanding of:

- **Requirement Analysis**: Identifying the needs of user or organizational needs to design an efficient database structure.
- **Relational Model Design**: Structuring the database using relationships between entities like employees, customers, orders, and inventory.
- **SQL and Database Management**: Writing and optimizing SQL queries for data manipulation and retrieval.
- **Application Development**: Creating a command-line interface to interact with the database and manage daily operations.
- **DBMS Architecture**: Understanding the components that make up a database system and how they work together.
- **Query Processing and Transaction Management**: Ensuring data integrity and consistency in multi-step operations.

This project allowed me to explore key DBMS concepts in a practical setting, reinforcing both technical skills and the importance of efficient data management in real-world applications.


## Overview
The **Restaurant Management System (RMS)** is a comprehensive database solution for managing key restaurant operations like inventory control, employee scheduling, customer ordering, and feedback management. The goal is to streamline daily activities, ensure quality service, and optimize resources for efficiency and customer satisfaction.

## Project Impact and Benefits
Managing a restaurant requires precision in coordinating staff, managing inventory, and processing customer orders. This system:

- **Reduces Wastage**: Helps control inventory usage and limits daily food waste.
- **Optimizes Staff Management**: Tracks employee shifts and tasks to ensure smooth operation.
- **Improves Customer Service**: Enables efficient order-taking, serving, and feedback gathering for continuous improvement.

## Key Features
- **Department and Employee Management**: Organizes staff within departments, assigns supervisors, and maintains schedules.
- **Inventory Tracking**: Monitors inventory levels, expiration dates, and supplier details, supporting effective inventory control.
- **Customer Order and Feedback Processing**: Records customer orders and feedback to improve service and adapt to customer needs.
- **Data Analytics for Business Goals**: Generates reports to increase daily sales, manage time efficiency, and enhance dine-in experiences.

## Entities and Data Flow
- **Employee**: Each employee has a unique ID and is assigned to a specific department with a supervisor and daily tasks.
- **Customer**: Stores customer information and their order and feedback details.
- **Department**: Organizes employees and supervisors in unique units with distinct roles.
- **Inventory**: Contains all items needed for the menu, with information on quantity, purchase date, and expiration.
- **Order**: Tracks customer orders, including the menu item details and preparation time.
- **Feedback**: Gathers customer feedback for each order, including suggestions and complaints.

## ER Diagram
The Entity-Relationship (ER) diagram below represents the structure of the Restaurant Management System, showing relationships among key entities such as Employees, Customers, Orders, Inventory, and Feedback.

![ER Diagram](https://github.com/shivani1105/Restaurant-Management-System/blob/main/ER%20diagram.jpg)

## ER-to-Relational Mapping
The following mapping shows how entities from the ER diagram are converted into relational tables after normalization:

- **Primary Keys** are underlined with solid lines.
- **Partial Keys** are underlined with dashed lines, and **Foreign Keys** are indicated in blue.

### Key Relations and Attributes:
- **EMPLOYEE (EID, F_Name, M_Name, L_Name, Gender, DOB, Salary, Phone#, Sup_ID, IMgrID)**
- **CUSTOMER (CID, Email, Phone#, Age, F_Name, L_Name, Gender)**
- **ORDER (ID, Order_Category, Type, Price, Order_Taken_Time, Order_Served_Time, CID, EID, Item_ID_Used)**
- **INVENTORY (Item_ID, Item_Name, Mfd_Date, Expiry_Date, Date_Purchased, Qty_Purchased, Item_Price, Qty_left_for_day)**
- **DEPARTMENT (Dept_ID, Dept_Name, MgrID, Start_Date)**
- **SUPPLIER (ID, Name)**
- **DAILY_SCHEDULE (Schedule_ID, EID, Start_Time, End_Time, Task)**
- **FEEDBACK (Order_ID, CID, Suggestion, Complaint, Rating_for_10)**
- **SUPPLIES (SID, Item_ID)**

Refer to the complete mapping document 'Mapping to Relations' for additional relations and functional dependencies.


## How to Use This System

## Setup and Usage Instructions

### 1. **Set Up the Environment on Omega**
   - Log into the Omega system provided by the university and navigate to your workspace.
   - Start `sqlplus` using your username and password:
     ```bash
     sqlplus {username}/{password}
     ```
   - This will allow you to run SQL commands directly or execute Java programs that connect to the database.

### 2. **Prepare the Database**
   - Use SQL files to create and set up the database structure:
     - **`projectDBcreate.sql`**: Contains `CREATE TABLE` statements to define tables for entities like `Employee`, `Customer`, `Inventory`, and `Order`.
     - **`projectDBdrop.sql`**: Use this file if you need to reset by dropping existing tables. Be cautious, as this will permanently delete tables and their data.
     - **`projectDBinsert.sql`**: Contains `INSERT INTO` statements to populate tables with initial data such as employee records, customer details, and inventory items.
     - **`projectDBupdate.sql`**: Used to apply any updates to the data after initial setup.

   - Run each SQL file on Omega using the following command:
     ```bash
     sqlplus username/password @path/to/your_sql_file.sql
     ```
   - For example, to create tables:
     ```bash
     sqlplus username/password @projectDBcreate.sql
     ```
   - These commands will execute all SQL statements within each file to set up and initialize your database.

### 3. **Data Population and Analysis**
   - **Populate the Database**: 
     - Use the `projectDBinsert.sql` file to insert predefined data into each table. This file will automate data insertion:
       ```bash
       sqlplus username/password @projectDBinsert.sql
       ```
   - **Run Queries for Analysis**:
     - For analysis, run the `projectDBqueries.sql` file containing common queries for reports, such as listing employees by department or checking inventory levels:
       ```bash
       sqlplus username/password @projectDBqueries.sql
       ```

### 4. **Accessing the Restaurant Management System**
   - After setting up the database, you can interact with the restaurant management system through the `OracleJDBCTeam2.java` file.
   - **Compile the Java Program**:
     ```bash
     javac OracleJDBCTeam2.java
     ```
   - **Run the Program**:
     - Execute the program to access various functionalities such as placing an order, viewing the menu, or accessing customer and inventory statistics:
       ```bash
       java OracleJDBCTeam2
       ```

### Sample Outputs
Here are some examples of the output you can expect from the command-line interface:

1. **Displaying Most Frequently Used Inventory Items**:
   ![Most Frequently Used Inventory Items](/Screenshots/fetch_customers.jpg)

2. **Customer Information Based on Specific Criteria**:
   ![Customer IDs and Emails of Frequent Customers](/Screenshots/groupby_query.jpg)

3. **Viewing the Restaurant Menu**:
   ![Restaurant Menu](/Screenshots/select_query.jpg)

Each SQL file is organized to streamline setup, data entry, and querying, making it easy to run complex queries without manually typing each command.

## Technical Requirements
- **Database**: SQL-based database, specifically **Oracle**, for structured data handling.
- **Command-Line Interface**: The project operates through command-line inputs on the Omega server, which allows for executing SQL and Java programs directly, even though it might not be the most user-friendly option.
- **Java and JDBC**: The project is developed using **Java**, with **JDBC** (Java Database Connectivity) used to establish and manage connections with the Oracle database.
- **SQL*Plus**: This tool is used to interact with the Oracle database in Omega, allowing commands like `CREATE TABLE`, `INSERT`, `DROP`, and `SELECT` for managing and querying data.
- **Text Editor on Omega**: Basic text editors such as `nano` are used to create and edit SQL and Java files directly on the Omega server.

## Contributions
Contributions are encouraged! Please open an issue or pull request if you have feature suggestions, find a bug, or want to discuss project improvements.
