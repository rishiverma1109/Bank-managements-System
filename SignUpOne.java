package Bank.Management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener {

    long random;
    JTextField nametextField , fnametextField, dobTextField, emailtextField, addresstextField, citytextField, statetextField, pincodetextField;
    JButton next;
    JRadioButton male , female , other, married , unmarried;
    JDateChooser dateChooser;

    SignUpOne() {
        setLayout(null);

        Random ran = new Random();
        random  = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO " + random);
        formno.setFont(new Font("RaleWay", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("RaleWay", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("RaleWay", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nametextField = new JTextField();
        nametextField.setFont(new Font("RaleWay", Font.BOLD, 14));
        nametextField.setBounds(300, 140, 400, 30);
        add(nametextField);

        JLabel Fname = new JLabel("Father Name:");
        Fname.setFont(new Font("RaleWay", Font.BOLD, 20));
        Fname.setBounds(100, 190, 200, 30);
        add(Fname);

        fnametextField = new JTextField();
        fnametextField.setFont(new Font("RaleWay", Font.BOLD, 14));
        fnametextField.setBounds(300, 190, 400, 30);
        add(fnametextField);

        JLabel DOB = new JLabel("Date Of Birth:");
        DOB.setFont(new Font("RaleWay", Font.BOLD, 20));
        DOB.setBounds(100, 240, 200, 30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105, 105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("RaleWay", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("RaleWay", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailtextField = new JTextField();
        emailtextField.setFont(new Font("RaleWay", Font.BOLD, 14));
        emailtextField.setBounds(300, 340, 400, 30);
        add(emailtextField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("RaleWay", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(630, 390, 100, 30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("RaleWay", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addresstextField = new JTextField();
        addresstextField.setFont(new Font("RaleWay", Font.BOLD, 14));
        addresstextField.setBounds(300, 440, 400, 30);
        add(addresstextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("RaleWay", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        citytextField = new JTextField();
        citytextField.setFont(new Font("RaleWay", Font.BOLD, 14));
        citytextField.setBounds(300, 490, 400, 30);
        add(citytextField);

        JLabel State = new JLabel("State:");
        State.setFont(new Font("RaleWay", Font.BOLD, 20));
        State.setBounds(100, 540, 200, 30);
        add(State);

        statetextField = new JTextField();
        statetextField.setFont(new Font("RaleWay", Font.BOLD, 14));
        statetextField.setBounds(300, 540, 400, 30);
        add(statetextField);

        JLabel pinCode = new JLabel("Pin code:");
        pinCode.setFont(new Font("RaleWay", Font.BOLD, 20));
        pinCode.setBounds(100, 590, 200, 30);
        add(pinCode);

        pincodetextField = new JTextField();
        pincodetextField.setFont(new Font("RaleWay", Font.BOLD, 14));
        pincodetextField.setBounds(300, 590, 400, 30);
        add(pincodetextField);

        JButton next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("RaleWay", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        String formno = " " + random;
        String name = nametextField.getText();
        String fname = nametextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null ;
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailtextField.getText();
        String marital= null;
        if (married.isSelected()){
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {

            marital = "Other";
        }

        String address = addresstextField.getText();
        String city = citytextField.getText();
        String state = statetextField.getText();
        String pin = pincodetextField.getText();



        try{
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");

            } else  {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new signUpTwo(formno).setVisible(true);

            }
        }catch (Exception e){
            System.out.println(e);
        }




    }


    public static void main(String[] args) {
        new SignUpOne();
    }
}
