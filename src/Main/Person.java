package Main;

import java.util.ArrayList;

public class Person {
    private String name;
    static int idGenerator=0 ;
    private int ID;
    private String pass;
    public boolean isInstructor;

    public Person(String name, String pass){
            setName(name); //setting name
            setID(++idGenerator);
            this.pass = pass;
//            System.out.print(getClass());
            this.isInstructor = String.valueOf(getClass()).equals("class Main.Instructor");
    }

//    setters
    public void setName(String name){
        this.name=name;
    }
    public void setID(int ID){
        this.ID=ID;
    }
//    getters
    public String getName(){
        return this.name;
    }
    public int getID(){
        return this.ID;
    }
    public String getPassword(){
        return this.pass;
    }

    //will over ride
    public ArrayList<Courses_Grades> getCourses(){
        return new ArrayList<Courses_Grades>();
    }
    public void removeCourse(int x){

    }
}