package Popup;

import javax.swing.*;
import java.awt.*;

public class Popup extends JFrame {
    public Popup(){
        setBounds(10,10,400,150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.black);

        //parent panel holds all
        JPanel parentPanel = new JPanel(new GridBagLayout());
        //children
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0; //column 0
        gbc.gridy=0; //row 0
        gbc.weightx=0.25;
        gbc.anchor=GridBagConstraints.WEST;
        JLabel firstLabel = new JLabel("Course Name");
        firstLabel.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        parentPanel.add(firstLabel,gbc);

        gbc.gridx=1;
        gbc.gridy=0;
        gbc.weightx=1;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.anchor=GridBagConstraints.EAST;
        JTextField firstTextField = new JTextField("first field");
        firstTextField.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        parentPanel.add(firstTextField,gbc);
        parentPanel.setBackground(Color.RED);

        gbc.gridx=0;
        gbc.gridy=5;
        gbc.weightx=0.25;
        gbc.fill= GridBagConstraints.NONE;
        gbc.anchor=GridBagConstraints.WEST;
        JLabel myLabel=new JLabel("second lable");
        myLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
//        myLabel.setBorder();
        parentPanel.add(myLabel,gbc);

        gbc.gridx=1;
        gbc.gridy=1;
        gbc.weightx=1;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.anchor=GridBagConstraints.EAST;
        JTextField myTextField = new JTextField("second field");
        myTextField.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        parentPanel.add(myTextField,gbc);
        parentPanel.setBackground(Color.RED);


        setContentPane(parentPanel);
//        add(parentPanel);

    }
    public static void main(String[] args){
        Popup test = new Popup();
    }
}
