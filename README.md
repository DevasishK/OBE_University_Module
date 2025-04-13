# **University Module - OBE Implementation Project**

## **Overview**

The **University Module** is part of the OBE (Outcome-Based Education) Implementation Project, developed using **Java** and **SQLite**. This module is responsible for managing university-related information, such as university code, name, address, email, and website. It allows users to perform **CRUD (Create, Retrieve, Update, Delete)** operations via a graphical user interface (GUI) built using **Java AWT**.

## **Features**

- **Create:** Allows users to insert new university records.
- **Retrieve:** Fetches existing university records based on the university code.
- **Update:** Updates the details of a university record.
- **Delete:** Deletes a university record from the database.

## **Technologies Used**

- **Java:** Programming language used for developing the desktop application.
- **AWT (Abstract Window Toolkit):** Java library for creating the GUI.
- **SQLite:** Database used for storing university records.

## **Setup Instructions**

### Prerequisites

Before running the project, ensure you have the following:

1. **Java JDK** (Version 8 or later) installed.
2. **SQLite JDBC driver** for Java (Ensure the JAR file is in your classpath).

### Steps to Set Up and Run

1. **Clone or Download the Project:**
   Download the project files and extract them into a folder.

2. **Database Setup:**
   Create a database named `javaapp.db` using SQLite. You can use any SQLite management tool to create the database with the following table schema:

   ```sql
   CREATE TABLE university (
       id INTEGER PRIMARY KEY,
       univ_code TEXT,
       univ_name TEXT,
       univ_address TEXT,
       univ_email TEXT,
       univ_website TEXT
   );
   ```

3. **Configure Database Path:**
   Ensure that the path to your `javaapp.db` database file is correctly specified in the code, especially in the following line:

   ```java
   SQLDB.connect("path_to_your_database/javaapp.db");
   ```

4. **Compile and Run the Application:**

   - Open your terminal/command prompt.
   - Navigate to the project directory.
   - Compile the Java files:

     ```bash
     javac UniversityAPP.java
     ```

   - Run the application:

     ```bash
     java UniversityApp
     ```

   This will launch the **University Module** GUI, allowing you to interact with the database.

## **Usage**

- **Create University Record:** Enter the details in the text fields and click the **Create** button.
- **Retrieve University Record:** Enter the university code in the **University Code** field and click **Retrieve** to fetch the record.
- **Update University Record:** Enter the updated details and click **Update**.
- **Delete University Record:** Enter the university code and click **Delete** to remove the record.

## **File Structure**

```
/UniversityModule
├── Meenarashi_University.java  # Main application class
├── SQLDB.java                  # Database connection and query execution class
├── javaapp.db                  # SQLite database file
└── README.md                   # Project documentation
```

## **Contributing**

Feel free to fork the repository, make improvements, and submit pull requests. Contributions are welcome!

