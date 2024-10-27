# Restaurant Management System (RMS)

## Project Learning and Objectives
This project was part of my coursework on Database Management Systems (DBMS), where I gained hands-on experience in building a database application with a user-focused approach. Through this project, I developed a deeper understanding of:

- **Requirement Analysis**: Identifying the needs of restaurant operations to design an efficient database structure.
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

## How to Use This System
1. **Set Up the Environment on Omega**:
   - Log into the Omega system provided by the university and navigate to your workspace.
   - Start `sqlplus` using your username and password:
     ```bash
     sqlplus {username}/{password}
     ```
   - This will allow you to run SQL commands directly or execute Java programs that connect to the database.

2. **Prepare the `OracleJDBCTeam2.java` File**:
   - Create a new Java file on Omega using the command:
     ```bash
     nano OracleJDBCTeam2.java
     ```
   - In this file, include your SQL queries and set up the database connection string with the correct `sqlplus` credentials.
   - Although the command-line interface isn’t ideal for database operations, it provides a straightforward way to execute embedded SQL queries and stored procedures for this project.

3. **Compile the Java Program**:
   - Compile the Java program on Omega to connect with the Oracle database:
     ```bash
     javac OracleJDBCTeam2.java
     ```

4. **Execute the Program**:
   - Run the compiled Java program to execute your SQL queries and view the results:
     ```bash
     java OracleJDBCTeam2
     ```

5. **Check Output and Reports**:
   - The program will fetch and display data on employee roles, inventory levels, orders, feedback, and other restaurant operations. Analyze the results to track business goals like increased sales and reduced food wastage.

## Setup and Usage Instructions
1. **Prepare Database**:
   - Ensure your database configuration is compatible with an SQL system like Oracle.
   - You may use commands such as `CREATE TABLE`, `INSERT`, `DROP`, and `SELECT` within SQL scripts to manage data tables.

2. **Upload Data**:
   - Populate the database with initial data for entities such as employees, inventory items, customers, and suppliers. Use SQL files or manual entries as needed.

3. **Run Application**:
   - After data is set up, execute the main script (`OracleJDBCTeam2.java`) through the command-line to interact with the database.

## Technical Requirements
- **Database**: SQL-based database, specifically **Oracle**, for structured data handling.
- **Command-Line Interface**: The project operates through command-line inputs on the Omega server, which allows for executing SQL and Java programs directly, even though it might not be the most user-friendly option.
- **Java and JDBC**: The project is developed using **Java**, with **JDBC** (Java Database Connectivity) used to establish and manage connections with the Oracle database.
- **SQL*Plus**: This tool is used to interact with the Oracle database in Omega, allowing commands like `CREATE TABLE`, `INSERT`, `DROP`, and `SELECT` for managing and querying data.
- **Text Editor on Omega**: Basic text editors such as `nano` are used to create and edit SQL and Java files directly on the Omega server.

## Contributions
Contributions are encouraged! Please open an issue or pull request if you have feature suggestions, find a bug, or want to discuss project improvements.
