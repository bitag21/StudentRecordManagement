---

# 📘 Student Record Management System (Java File I/O)

## 📌 Project Overview

This is a simple console-based Student Record Management System developed using Java.
The system allows users to manage student information and practice file handling concepts using different types of Java streams.

---

## 🎯 Features

The system supports the following operations:

* Add a new student
* Search student by ID
* Update student information
* Delete student record
* Display all students
* Generate student report (total, highest GPA, lowest GPA, average GPA)

---

## 💾 File Handling

This project demonstrates different ways of storing data in Java:

### 1. Text File Storage

* Uses `Scanner` and `PrintWriter`
* Stores data in a readable `.txt` file

### 2. Binary File Storage

* Uses `DataInputStream` and `DataOutputStream`
* Stores data in `.dat` format

### 3. Object Serialization

* Uses `ObjectInputStream` and `ObjectOutputStream`
* Stores complete objects in `.obj` file

---

## 📂 Additional File Features

* Automatically creates required folder (`StudentRecords`)
* Displays file information (name, path, size, last modified date)
* Creates backup of student records using buffered streams

---

## 🧠 Technologies Used

* Java
* Object-Oriented Programming (OOP)
* File I/O Streams
* ArrayList
* Exception Handling

---

## ▶️ How to Run

1. Compile all Java files:

```
javac *.java
```

2. Run the program:

```
java Main
```

---

## 📁 Project Structure

```
StudentRecordManagement/
│
├── FileManager.java
├── Main.java
├── Student.java
├── StudentManager.java
├── StudentRecords/   (created automatically by the program)
```

---

## 📌 Notes

* Data is stored in memory during runtime unless saved to file.
* Always save data before exiting if you want to keep records.
* The system is designed for learning Java file handling and OOP concepts.

---
Done by: Wuberst Goshu
---

