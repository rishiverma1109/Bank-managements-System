package Bank.Management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;


public class FastCash extends JFrame implements ActionListener {

    JButton deposite, cash, fastCash, miniStatement, pinchange, BalanceEnquire, exit;
    String pinnumber;

    FastCash(String pinnumber){
        this.pinnumber = pinnumber; // Initialize pinnumber
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposite = new JButton("RS 100");
        deposite.setBounds(170, 415, 150, 30);
        deposite.addActionListener(this);
        image.add(deposite);

        cash = new JButton("RS 500");
        cash.setBounds(355, 415, 150, 30);
        cash.addActionListener(this);
        image.add(cash);

        fastCash = new JButton("RS 1000");
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("RS 2000");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinchange = new JButton("RS 5000");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        BalanceEnquire = new JButton("10000");
        BalanceEnquire.setBounds(353, 485, 150, 30);
        BalanceEnquire.addActionListener(this);
        image.add(BalanceEnquire);

        exit = new JButton("BACK");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
           String amount = ((JButton) e.getSource()).getText().substring(3);
           Conn c = new Conn();
           try{
               ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
               int balance = 0;
               while (rs.next()){
                   if (rs.getString("type").equals("Deposit")){
                       balance+=Integer.parseInt(rs.getString("amount"));
                   }else {
                       balance -= Integer.parseInt(rs.getString("amount"));
                   }
               }
               if (e.getSource() != exit && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficent Balance");
                   return;
               }
               Date date = new Date();
               String query = "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"RS "+ amount +"Debited sucessfuly");

               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
           }
           catch (Exception ae){
               System.out.println(e);
           }
        }
        }


    public static void main(String[] args) {
        new FastCash("");
    }
}
