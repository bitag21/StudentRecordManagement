import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        FileManager fileManager = new FileManager();

        int choice;

        do {
            showMenu();

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    addStudent(input, manager);
                    break;

                case 2:
                    searchStudent(input, manager);
                    break;

                case 3:
                    updateStudent(input, manager);
                    break;

                case 4:
                    deleteStudent(input, manager);
                    break;

                case 5:
                    manager.displayAllStudents();
                    break;

                case 6:
                    fileManager.saveToTextFile(manager.getStudents());
                    break;

                case 7:
                    manager.setStudents(fileManager.loadFromTextFile());
                    System.out.println("Loaded from text file.");
                    break;

                case 8:
                    fileManager.saveToBinaryFile(manager.getStudents());
                    break;

                case 9:
                    manager.setStudents(fileManager.loadFromBinaryFile());
                    System.out.println("Loaded from binary file.");
                    break;

                case 10:
                    fileManager.saveObjects(manager.getStudents());
                    break;

                case 11:
                    manager.setStudents(fileManager.loadObjects());
                    System.out.println("Loaded objects.");
                    break;

                case 12:
                    manager.generateReport();
                    break;

                case 13:
                    fileManager.showFileProperties();
                    break;

                case 14:
                    fileManager.backupTextFile();
                    break;

                case 15:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 15);

        input.close();
    }

    // menu only
    private static void showMenu() {
        System.out.println("""
        \n===== Student Record Management System =====
        1. Add Student
        2. Search Student
        3. Update Student
        4. Delete Student
        5. Display All Students
        6. Save to Text File
        7. Load from Text File
        8. Save to Binary File
        9. Load from Binary File
        10. Save Objects
        11. Load Objects
        12. Generate Report
        13. Show File Properties
        14. Backup Text File
        15. Exit
        """);

        System.out.print("Enter choice: ");
    }

    // add student
    private static void addStudent(Scanner input, StudentManager manager) {

        System.out.print("Enter ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter Name: ");
        String name = input.nextLine();

        System.out.print("Enter Department: ");
        String dept = input.nextLine();

        System.out.print("Enter GPA: ");
        double gpa = input.nextDouble();
        input.nextLine();

        manager.addStudent(new Student(id, name, dept, gpa));
        System.out.println("Student added.");
    }

    // search student
    private static void searchStudent(Scanner input, StudentManager manager) {

        System.out.print("Enter ID: ");
        int id = input.nextInt();
        input.nextLine();

        Student s = manager.searchStudent(id);

        if (s != null)
            System.out.println(s);
        else
            System.out.println("Student not found.");
    }

    // update student
    private static void updateStudent(Scanner input, StudentManager manager) {

        System.out.print("Enter ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter new Name: ");
        String name = input.nextLine();

        System.out.print("Enter new Department: ");
        String dept = input.nextLine();

        System.out.print("Enter new GPA: ");
        double gpa = input.nextDouble();
        input.nextLine();

        if (manager.updateStudent(id, name, dept, gpa))
            System.out.println("Updated successfully.");
        else
            System.out.println("Student not found.");
    }

    // delete student
    private static void deleteStudent(Scanner input, StudentManager manager) {

        System.out.print("Enter ID: ");
        int id = input.nextInt();
        input.nextLine();

        if (manager.deleteStudent(id))
            System.out.println("Deleted successfully.");
        else
            System.out.println("Student not found.");
    }
}