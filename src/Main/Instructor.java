package Main;

import java.util.ArrayList;
//package src;

public class Instructor extends Person  {
    //id,name
    private String Instructorpass ="inst"+ getID();

    public String getInstructorpass() {
        return Instructorpass;
    }
    public Instructor(String name , String pass) {
        super(name,pass);
    }


    public void addStudent (ArrayList<Student> students ,  Student student ) {
            students.add(student);
    }
    public void removeStudent (ArrayList<Student> students , Student student ) {
            students.remove(student);
    }
    public void displayStudents(ArrayList<Student> students) {
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", ID: " + student.getID());
        }
    }

}
