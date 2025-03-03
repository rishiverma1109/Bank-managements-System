package Bank.Management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signUpTwo extends JFrame implements ActionListener {


        JTextField  aadhar,pan;
        JButton next;
        JRadioButton syes,sno,eyes,eno;
        JComboBox  income , category , occupation , education ,religion;
        String formno;

    signUpTwo(String formno) {
        this.formno = formno;
            setLayout(null);

            setTitle("NEW ACCOUNT APPLICATION FORM NO: ");

            JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("RaleWay", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

            JLabel name = new JLabel("Religion:");
            name.setFont(new Font("RaleWay", Font.BOLD, 20));
            name.setBounds(100, 140, 100, 30);
            add(name);

            String valReligion[] ={"Hindu","Muslim","Sikh","Christans","Other"};
            religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);



            JLabel Fname = new JLabel("Category:");
            Fname.setFont(new Font("RaleWay", Font.BOLD, 20));
            Fname.setBounds(100, 190, 200, 30);
            add(Fname);

            String valcategory[] = {"General","OBC","SC","ST","Other"};
             category = new JComboBox(valcategory);
            category.setBounds(300, 190, 400, 30);
            category.setBackground(Color.white);
            add(category);

            JLabel DOB = new JLabel("Income:");
            DOB.setFont(new Font("RaleWay", Font.BOLD, 20));
            DOB.setBounds(100, 240, 200, 30);
            add(DOB);

        String incomeCategory[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","UpTo 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);


            JLabel gender = new JLabel("Educational:");
            gender.setFont(new Font("RaleWay", Font.BOLD, 20));
            gender.setBounds(100, 290, 200, 30);
            add(gender);


            JLabel email = new JLabel("Qualification:");
            email.setFont(new Font("RaleWay", Font.BOLD, 20));
            email.setBounds(100, 315, 200, 30);
            add(email);

        String EducatonValues[] = {"Non Graduate","Graduate","Post Graduation","Doctrate","Others"};
         education = new JComboBox(EducatonValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.white);
        add(education);



            JLabel marital = new JLabel("Occupation:");
            marital.setFont(new Font("RaleWay", Font.BOLD, 20));
            marital.setBounds(100, 390, 200, 30);
            add(marital);

        String OccupationValues[] = {"Salaried","Self Employed","Bussiness","Student","Retired","Others"};
         occupation = new JComboBox(OccupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);


            JLabel address = new JLabel("Pan Number:");
            address.setFont(new Font("RaleWay", Font.BOLD, 20));
            address.setBounds(100, 440, 200, 30);
            add(address);

            pan = new JTextField();
            pan.setFont(new Font("RaleWay", Font.BOLD, 14));
            pan.setBounds(300, 440, 400, 30);
            add(pan);

            JLabel city = new JLabel("Aadhar Number:");
            city.setFont(new Font("RaleWay", Font.BOLD, 20));
            city.setBounds(100, 490, 200, 30);
            add(city);

            aadhar = new JTextField();
            aadhar.setFont(new Font("RaleWay", Font.BOLD, 14));
            aadhar.setBounds(300, 490, 400, 30);
            add(aadhar);

            JLabel State = new JLabel("Senior Citizen:");
            State.setFont(new Font("RaleWay", Font.BOLD, 20));
            State.setBounds(100, 540, 200, 30);
            add(State);


        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(syes);
        maritalGroup.add(sno);



            JLabel pinCode = new JLabel("Exisiting Account:");
            pinCode.setFont(new Font("RaleWay", Font.BOLD, 20));
            pinCode.setBounds(100, 590, 200, 30);
            add(pinCode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup emaritalGroup = new ButtonGroup();
        emaritalGroup.add(eyes);
        emaritalGroup.add(eno);

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


            String sreligion = (String) religion.getSelectedItem();
            String scategory = (String) category.getSelectedItem();
            String sincome=  (String) income.getSelectedItem();
            String seducation = (String) education.getSelectedItem();
            String soccupation=  (String) occupation.getSelectedItem();
            String seniorsetigion = null;
            if (syes.isSelected()){
                seniorsetigion = "Yes";
            } else if (sno.isSelected()) {
                seniorsetigion = "No";
            }


            String existingAccount= null;
            if (eyes.isSelected()){
                existingAccount = "Yes";
            } else if (eno.isSelected()) {
                existingAccount  = "No";
            }

            String span = pan.getText();
            String saadhar = aadhar.getText();




            try{
                    Conn c = new Conn();
                    String query = "insert into signupTwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorsetigion+"','"+existingAccount+"')";
                    c.s.executeUpdate(query);

                    setVisible(false);
                    new signUpTwo(formno).setVisible(true);

                    //Signup3 object
                setVisible(false);
                new SignUpThree(formno).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }




        }


        public static void main(String[] args) {
            new signUpTwo("");
        }
    }


