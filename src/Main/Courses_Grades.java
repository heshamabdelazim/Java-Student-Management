package Main;

public class Courses_Grades {
    private String subject="hello";
    private double grade=0.00;
    private static int idGenerator =0;
    private char gradeLetter; //A ,B ,C ,D ,F
    private int courseId;

    public Courses_Grades(String subject, double grade){
        this.subject = subject;
        this.grade=grade;
        this.gradeLetter= calcGrade(grade);
        this.courseId=++idGenerator;
    }

    public Courses_Grades(String subject){
        this.subject=subject;
        this.courseId=++idGenerator;
    }

    private char calcGrade(double x){
        if(x>=85){
            return 'A';
        }
        else if(x>=75){
            return 'B';
        }
        else if(x>65){
            return 'C';
        }
        else if (x>=50){
            return 'D';
        }
        return 'F';
    }
    //getters
    public String getCourse(){
        return this.subject;
    }
    public double getGrade(){
        return this.grade;
    }
    public char getGradeLetter(){
        return this.gradeLetter;
    }
    public int getCourseId(){
        return this.courseId;
    }

    public static void main(String []args){
        Courses_Grades x = new Courses_Grades("Math",66.6);
        System.out.println(x.getGrade());
        System.out.println(x.getGradeLetter());
        Courses_Grades y = new Courses_Grades("Math",85.1);
        System.out.println(y.getGrade());
        System.out.println(y.getGradeLetter());
    }
}
