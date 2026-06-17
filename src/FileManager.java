//import necessary package classes to perform file operations

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;


public class FileManager {

    //attribute for file manager
    private File folder;
    private File textFile;

    //method for creating new file and folder
    public FileManager(){
        folder = new File("StudentRecords");
        textFile = new File(folder, "students.txt");

        try{
            if (!folder.exists()){
                folder.mkdirs();
            }
            if (!textFile.exists()){
                textFile.createNewFile();
            }

        } catch (Exception e) {
            System.out.println("Error creating file.");
        }
    }

    //method to save student lists to file
    public void saveToTextFile(ArrayList<Student>students){
        try{

            PrintWriter writer = new PrintWriter(textFile);

            //for loop for writing students list
            for (Student student : students){
                writer.println(student.getStudentID() + "," + student.getName() + "," + student.getDepartment() +"," + student.getGpa());
            }
            writer.close();

            System.out.println("Students saved successfully.");

        }catch (Exception e){
            System.out.println("Error saving students.");
        }
    }

    //method for reading information from the file
    public ArrayList<Student>loadFromTextFile(){
        ArrayList<Student> students = new ArrayList<>();
        try {
            Scanner fileReader = new Scanner(textFile);

            while (fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String department = data[2];
                double gpa = Double.parseDouble(data[3]);

                students.add(new Student(id, name, department, gpa));
            }

            fileReader.close();

        }catch (Exception e){
            System.out.println("Error loading students.");
        }
        return students;
    }

    // method to show file properties
    public void showFileProperties(){
        System.out.println("File Name: " + textFile.getName());
        System.out.println("File path: " + textFile.getAbsolutePath());
        System.out.println("File Size: " + textFile.length() + " bytes");
        System.out.println("Last Modified: "+ textFile.lastModified());
    }

    // methods to save date to a file
    public void saveToBinaryFile(ArrayList<Student> students) {

        try {

            DataOutputStream output =
                    new DataOutputStream(new FileOutputStream("StudentRecords/students.dat"));

            output.writeInt(students.size());

            for (Student student : students) {

                output.writeInt(student.getStudentID());
                output.writeUTF(student.getName());
                output.writeUTF(student.getDepartment());
                output.writeDouble(student.getGpa());

            }

            output.close();

            System.out.println("Binary file saved successfully.");

        } catch (Exception e) {

            System.out.println("Error saving binary file.");

        }
    }

    // method to write on a file
    public ArrayList<Student> loadFromBinaryFile() {

        ArrayList<Student> students = new ArrayList<>();

        try {

            DataInputStream input =
                    new DataInputStream(new FileInputStream("StudentRecords/students.dat"));

            int total = input.readInt();

            for (int i = 0; i < total; i++) {

                int id = input.readInt();
                String name = input.readUTF();
                String department = input.readUTF();
                double gpa = input.readDouble();

                students.add(new Student(id, name, department, gpa));

            }

            input.close();

        } catch (Exception e) {

            System.out.println("Error loading binary file.");

        }

        return students;

    }


    public void saveObjects(ArrayList<Student> students) {

        try {

            ObjectOutputStream output =
                    new ObjectOutputStream(new FileOutputStream("StudentRecords/students.obj"));

            output.writeObject(students);

            output.close();

            System.out.println("Objects saved successfully.");

        } catch (Exception e) {

            System.out.println("Serialization error.");

        }

    }


    @SuppressWarnings("unchecked")
    public ArrayList<Student> loadObjects() {

        ArrayList<Student> students = new ArrayList<>();

        try {

            ObjectInputStream input =
                    new ObjectInputStream(new FileInputStream("StudentRecords/students.obj"));

            students = (ArrayList<Student>) input.readObject();

            input.close();

        } catch (Exception e) {

            System.out.println("Error loading serialized objects.");

        }

        return students;

    }

    public void backupTextFile() {

        try {

            BufferedInputStream input =
                    new BufferedInputStream(new FileInputStream("StudentRecords/students.txt"));

            BufferedOutputStream output =
                    new BufferedOutputStream(new FileOutputStream("StudentRecords/students_backup.txt"));

            int data;

            while ((data = input.read()) != -1) {

                output.write(data);

            }

            input.close();
            output.close();

            System.out.println("Backup completed successfully.");

        } catch (Exception e) {

            System.out.println("Backup failed.");

        }
    }
}
