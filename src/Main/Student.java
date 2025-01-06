package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student extends Person{
    private Courses_Grades[] all = {
            new Courses_Grades("Arabic", 50.5),
            new Courses_Grades("English",90)
    };
    List<Courses_Grades> modifyAll = Arrays.asList(all);
    private ArrayList<Courses_Grades> studentCourses = new ArrayList<Courses_Grades>(modifyAll);


    public Student(String name, String pass) {
        super(name,pass);
    }

    public Student(String name, String pass,Courses_Grades course){
        super(name,pass);
        this.studentCourses.add(course);
    }
    public void addCourse(Courses_Grades course){
        studentCourses.add(course);
    }
@Override
    public ArrayList<Courses_Grades> getCourses(){
        return this.studentCourses;
    }
@Override
public  void removeCourse(int x){
    this.studentCourses.remove(x);
}
    //id,name
}
