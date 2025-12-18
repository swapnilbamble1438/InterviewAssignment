# Bank Transaction Management System (Java J2EE – Maven)

## 📌 Project Overview
This is a **Java J2EE Maven-based web application** built using **Servlets, JSP, AJAX, and MySQL** to manage and view bank transaction records.

The application supports **multiple search filters** and dynamically displays results on the **same page without reload** using AJAX.  
Filtered data can also be exported to **Excel (XLSX)** and **PDF** formats.

The project follows a **traditional MVC architecture** and is compatible with **Apache Tomcat 8.5** and **Java 8**.

---

### Assignment Screenshot:
!(Assingmentscreenshot.png)

## 🛠 Technologies Used
- Java 8
- JSP & Servlets
- AJAX (jQuery)
- MySQL
- Apache Tomcat 8.5
- Maven
- Apache POI (Excel export)
- iText (PDF export)


## 📂 Project Structure

📂src

 └── main
 
     ├── java
     │     ├── com.controller
     │     │        ├── TransactionServlet.java
     │     │        └── ExportServlet.java
     │     ├── com.dao
     │     │        └── TransactionDAO.java
     │     └── com.entity
     │              └── Transaction.java
     │
     └── webapp
           ├── jsp
           │    ├── index.jsp
           │    └── result.jsp
           └── WEB-INF
                └── web.xml

## 🧾 Features
- Multiple search filters:
  - From Date
  - To Date
  - Transaction Status
  - Bank Name
  - Corporate ID
- AJAX-based filtering (no page reload)
- Displays **15+ transaction-related columns**
- Export filtered results to:
  - Excel (.xlsx)
  - PDF
- Simple JSP UI (no DataTables or frontend frameworks)

---

## 🗃 Database Details

### Database
MySQL

### Table Name
`transactions`

### Columns
- id
- corporate_id
- unique_id
- beneficiary_name
- account_number
- ifsc
- bank_name
- amount
- currency
- transaction_type
- transaction_status
- channel
- remarks
- created_by
- created_date
- updated_date

---

## 🔄 Database Change Required (IMPORTANT)

> **Database configuration must be updated after importing the project.**
** paste queries from MySql Queries File.

Update database connection details in code:

com.util.DBUtil class
Update:

Database URL

Username

Password

⚠️ Application will not run until database details are updated.

▶ How to Run the Project (Maven)
Import the project into Eclipse as Existing Maven Project

Allow Maven to download all dependencies automatically

Configure Apache Tomcat 8.5

Update database configuration (mandatory)

Run the project on Tomcat

Access the application:
using url:
http://localhost:8080/project-name/index.jsp     
or    
http://localhost:8080/project-name
or 
simply use Run on Server option by right clicking on project

✅ No manual JAR addition is required – all dependencies are managed via Maven.
