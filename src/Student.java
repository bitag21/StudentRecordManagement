import java.io.Serializable;

public class Student implements Serializable {

    //Attributes of student
    private final int studentID;
    private String name;
    private String department;
    private double gpa;

    //constructor for student class
    public Student(int studentID, String name, String department, double gpa) {
        this.studentID = studentID;
        this.name = name;
        this.department = department;
        this.gpa = gpa;
    }

    //getters for student class
    //getter for student id
    public int getStudentID() {

        return studentID;
    }
    //getter for student name
    public String getName() {

        return name;
    }
    //getter for student department
    public String getDepartment() {

        return department;
    }
    //getter for student gpa
    public double getGpa() {

        return gpa;
    }

    //setters
    //setter for student name
    public void setName(String name) {

        this.name = name;
    }
    //setter for student department
    public void setDepartment(String department) {

        this.department = department;
    }
    //setter for student gpa
    public void setGpa(double gpa) {

        this.gpa = gpa;
    }

//overrides the toString() method from Object class to display student details
    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nName: " + name + "\nDepartment: " + department + "\nGPA: " + gpa;
    }
}
