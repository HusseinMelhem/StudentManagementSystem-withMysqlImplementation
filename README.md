# 📚 Student Management System with MySQL

A **JavaFX-based Student Management System** with **MySQL integration** that allows users to **add, view, search, and delete students**. It also includes a **user authentication system**.

## 🎯 Features
✅ **Add, Edit, Delete Students**  
✅ **View All Students**  
✅ **Search by Name or ID**  
✅ **User Login System (Admin Only)**  
✅ **Automatically Creates Database Tables**  

---

## 📌 Setup Instructions
### 🔹 1. Install Required Software
- Install **Java 17 or later** [Download](https://www.oracle.com/java/technologies/javase-downloads.html)
- Install **JavaFX SDK** [Download](https://gluonhq.com/products/javafx/)
- Install **MySQL Server & MySQL Workbench** [Download](https://dev.mysql.com/downloads/)

### 🔹 2. Clone This Repository
```sh
git clone https://github.com/HusseinMelhem/StudentManagementSystem-withMysql.git
cd StudentManagementSystem-withMysql
🔹 3. Configure MySQL Database
1️⃣ Open MySQL Workbench
2️⃣ Create a new database:

sql
Copy
Edit
CREATE DATABASE IF NOT EXISTS student_db;
USE student_db;
3️⃣ Run these queries to create the tables:

sql
Copy
Edit
CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    grade VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);
4️⃣ Insert a sample admin user:

sql
Copy
Edit
INSERT INTO users (username, password) VALUES ('admin', 'admin123');
🔹 4. Run the Application
1️⃣ Open Eclipse
2️⃣ Import the project
3️⃣ Run LoginGUI.java

🔗 Related Projects
Inventory Management System with MySQL
