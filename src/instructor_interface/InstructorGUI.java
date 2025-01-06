package instructor_interface;

import Login.Login;
import Main.Courses_Grades;
import Main.Person;
import Main.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;



public class InstructorGUI extends JFrame {
    private JPanel panelHeader;
    private JPanel panelWindow;
    private JLabel labelHello;
    private JLabel labelName;
    private JButton logOutButton;
    private JLabel labelToday;
    private JLabel labelIcon;
    private JPanel panelStudents;
    private JPanel panelDetails;
    private JLabel labelDetails;
    private JPanel panelBodyDetails;

    private Person clickedStudent;
    private boolean isInstructorUI;
    public InstructorGUI(Person chosen, ArrayList<Student> StudentsList){
        clickedStudent=chosen.isInstructor?StudentsList.get(0):chosen;
        this.isInstructorUI = chosen.isInstructor;

        initialUI(chosen, clickedStudent); //UI
        header(chosen);
        btnsStudents(chosen,StudentsList);
        theBigBestDetails(clickedStudent);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login x = new Login();
            }
        });
    }

    private void initialUI(Person chosen , Person clickedStudent ){
        setContentPane(panelWindow);
        setVisible(true);
        System.out.println(chosen.isInstructor + " " + chosen.getName());
        setIconImage(new ImageIcon("src/images/logo.png").getImage());
        setTitle(chosen.isInstructor?"Instructor ": "Student " + chosen.getName() + " Interface");
        setBounds(100,100,1200,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        pack();
    }

    private void header(Person chosen) {
        labelHello.setText("Hello " + (chosen.isInstructor? "Instructor " : "Student"));
        labelName.setText(chosen.getName());
        labelToday.setText(", Today is " + LocalDate.now());
        labelIcon.setIcon(resizedIcon("src/images/user.png",30,30));
    }

    private void btnsStudents(Person chosen, ArrayList<Student> StudentsList ){
        if(chosen.isInstructor){
            int index = 0;
            for(Person x:StudentsList ){
                JButton user = new JButton(x.getName(),resizedIcon("src/images/user.png",10,10));
                user.setFont(user.getFont().deriveFont(18f));
                user.setForeground(new Color(75,84,113));
                panelStudents.add(user);
                user.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
//                        System.out.println(x.getName());
                        clickedStudent= x;
                        theBigBestDetails( clickedStudent);
                    }
                });
            }
        }else{
            JLabel labelSorry= new JLabel("Sorry you are not Instructor to modify Your Colleagues");
            labelSorry.setFont(labelSorry.getFont().deriveFont(16f));
            panelStudents.add(labelSorry);
        }
    }


    private void theBigBestDetails( Person clickedStudent) {
        //this chosen might be instructor or student
        panelBodyDetails.setLayout(new GridLayout(clickedStudent.getCourses().size(),3));

        panelBodyDetails.removeAll(); // Remove all components from the panel
        panelBodyDetails.revalidate(); // Revalidate the layout
        panelBodyDetails.repaint();   // Repaint the panel to reflect the change

        labelDetails.setText(this.isInstructorUI? clickedStudent.getName()+"'s Details" : "Your Details");

        ArrayList<Courses_Grades> allCourses = clickedStudent.getCourses(); //array of objects

        for(Courses_Grades everyCourse : allCourses){
            JPanel somePanel = new JPanel(new BorderLayout(10,2));
//            ============arrow label
            JLabel labelCounter = new JLabel(String.valueOf(everyCourse.getCourseId()+1)+"- ");
            labelCounter.setFont(labelCounter.getFont().deriveFont(20f));
            somePanel.add(labelCounter,BorderLayout.WEST);
//            =============panel subject
            JPanel panelSubject = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
            JLabel subjectName = new JLabel(everyCourse.getCourse());
            JLabel gradePercent = new JLabel(String.valueOf(everyCourse.getGrade()));
            JLabel gradeLetter = new JLabel("("+ String.valueOf(everyCourse.getGradeLetter()) + ")");

            subjectName.setFont(subjectName.getFont().deriveFont(20f));
            gradePercent.setFont(gradePercent.getFont().deriveFont(20f));
            gradeLetter.setFont(gradeLetter.getFont().deriveFont(20f));


            panelSubject.add(subjectName);
            panelSubject.add(gradePercent);
            panelSubject.add(gradeLetter);
            somePanel.add(panelSubject,BorderLayout.CENTER);
//            ==================================
            JPanel panelBtns = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton edit = new JButton("edit");
            JButton delete = new JButton("delete");
            panelBtns.add(edit);
            panelBtns.add(delete);
            somePanel.add(panelBtns,BorderLayout.EAST);
            panelBodyDetails.add(somePanel);
//            add - edit functionality
            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clickedStudent.removeCourse(everyCourse.getCourseId());
                    theBigBestDetails(clickedStudent);
                }
            });
        }

    }

    private Icon resizedIcon (String path, int el3rd, int elTol){
        Image myUserIcon = new ImageIcon(path).getImage();
        Image scaledImage = myUserIcon.getScaledInstance(el3rd,elTol,Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

}
