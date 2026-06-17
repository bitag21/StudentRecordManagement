import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;


    //getter for student arraylist
    public ArrayList<Student> getStudents() {

        return students;
    }
    //setter for student array list
    public void setStudents(ArrayList<Student> students){

        this.students = students;
    }

// method for creating new array list
    public StudentManager() {
        students = new ArrayList<>();
    }

    //adding student method
    public void addStudent(Student student) {
        students.add(student);
    }

    //searching student method
    public Student searchStudent(int studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                return student;
            }
        }
        return null; // Return null if student not found
    }

    //method for updating student information
    public boolean updateStudent(int studentID, String name, String department, double gpa) {
        // Search about the student using searchStudent method
        Student student = searchStudent(studentID);
        if (student != null) {
            student.setName(name);
            student.setDepartment(department);
            student.setGpa(gpa);
            return true; // Update successful
        }
        return false; // Student not found
    }

    //method for deleting student information
    public boolean deleteStudent(int studentID) {
        // Search about the student using searchStudent method
        Student student = searchStudent(studentID);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }

    //method to display information of students
    public void displayAllStudents(){
        if(students.isEmpty()){
            System.out.println("No students found.");
            return;
        }
        for(Student student : students){
            System.out.println(student);
        }
    }


    // method for Generate Student Report
    public void generateReport() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        double highestGpa = students.get(0).getGpa();
        double lowestGpa = students.get(0).getGpa();
        double totalGpa = 0;

        Student highestStudent = students.get(0);
        Student lowestStudent = students.get(0);

        // for loop for getting the highest gpa and lowest gpa from students in arraylist
        for (Student student : students) {

            totalGpa += student.getGpa();

            if (student.getGpa() > highestGpa) {
                highestGpa = student.getGpa();
                highestStudent = student;
            }

            if (student.getGpa() < lowestGpa) {
                lowestGpa = student.getGpa();
                lowestStudent = student;
            }

        }
        double average = totalGpa / students.size();

        System.out.println("\n===== Student Report =====");
        System.out.println("Total Students : " + students.size());
        System.out.println("Highest GPA    : " + highestStudent.getName() + " (" + highestGpa + ")");
        System.out.println("Lowest GPA     : " + lowestStudent.getName() + " (" + lowestGpa + ")");
        System.out.println("Average GPA    : " + average);

    }

}
