package Login;

import Main.Courses_Grades;
import Main.Instructor;
import Main.Person;
import Main.Student;
import Dashboard.DashboardGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Login extends JFrame {
    private JPanel panelBody;
    private JButton loginButton;
    private JLabel labelHeader;
    private JPanel panelBtnsBar;
    private JPanel pnaleUserFields;
    private JTextField fieldAccount;
    private JTextField fieldPassword;
    private JLabel label;
    private JLabel labelLoginStatus;
    private boolean isUser = false;
    private Person chosen = null;
    //================ArrayList of Students
    private Student[] allStudents= {
            new Student("Hesham", "Hesh",new Courses_Grades("Maths",60.6)),
            new Student("Philip","Phil"),
            new Student("Hassan","Has")
    };
    private List listOfAllStudents = Arrays.asList(allStudents);
    public ArrayList<Student> Students = new ArrayList<Student>(listOfAllStudents);
    //================ArrayList of Instructors
    private Instructor[] allInstructors = {
            new Instructor("Wessam","Wessam"),
            new Instructor("AbdElRhman","Abdo"),
            new Instructor("Mina","Mina")
    };
    private List<Instructor> listOfAllInstructors = Arrays.asList(allInstructors);
    public ArrayList<Instructor> Instructors = new ArrayList<Instructor>(listOfAllInstructors);

    public Login() {
        tryUsers(Students, Instructors);

        ArrayList<Person> allPeople = new ArrayList<Person>(Instructors);
        allPeople.addAll(Students);
//        ===================== Start GUI
        setTitle("Student management - Login");
        setIconImage(new ImageIcon("src/images/logo.png").getImage());
        setContentPane(panelBody);
        setVisible(true);
        setBounds(150, 150, 650, 270);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index =0;
                isUser=false;
                while (!isUser && index < allPeople.size()) {
                    if(fieldAccount.getText().equals(allPeople.get(index).getName()) && fieldPassword.getText().equals(allPeople.get(index).getPassword())){
                        isUser = true;
                        chosen = allPeople.get(index);
                        labelLoginStatus.setText("login success");
//                        setVisible(false);
                        DashboardGUI Instructor_Interface = new DashboardGUI(chosen , Students);
                        dispose();
                    }else{
                        labelLoginStatus.setText("Sorry, Wrong user name or password");
                        isUser=false;
                    }
                        index++;
                }
            }
        });
}
private void tryUsers(ArrayList<Student> allStudents, ArrayList<Instructor> allInstructors){
        final String dash= "---------------";
        System.out.println(dash);
        System.out.println("Try Student Accounts");
        System.out.println(dash);
        for(Student x: allStudents ){
            System.out.println("User Name: "+ x.getName() + " AND Password: " + x.getPassword());
        }
        System.out.println(dash);
        System.out.println("Try Instructor Accounts");
        System.out.println(dash);
        for(Instructor x : allInstructors){
            System.out.println("User Name: "+ x.getName() + " AND Password: " + x.getPassword());
        }
        System.out.println(dash);
}
 public static void main(String[] args){
     Login test = new Login();
 }
}
