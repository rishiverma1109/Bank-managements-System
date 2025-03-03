package Bank.Management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposite, cash, fastCash, miniStatement, pinchange, BalanceEnquire,exit;
    String pinnumber;

    Transactions(String pinnumber){
        this.pinnumber = pinnumber; // Initialize pinnumber
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposite = new JButton("Deposite");
        deposite.setBounds(170, 415, 150, 30);
        deposite.addActionListener(this);
        image.add(deposite);

        cash = new JButton("Cash Withdrawl");
        cash.setBounds(355, 415, 150, 30);
        cash.addActionListener(this);
        image.add(cash);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        BalanceEnquire = new JButton("Balance Enquiry");
        BalanceEnquire.setBounds(353, 485, 150, 30);
        BalanceEnquire.addActionListener(this);
        image.add(BalanceEnquire);

        exit = new JButton("Exit");
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
            System.exit(0);
        } else if(e.getSource() == deposite){
            setVisible(false);
            new Deposite(pinnumber).setVisible(true);
        } else if(e.getSource() == cash){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true); // Fixed the variable name
        } else if (e.getSource()==fastCash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);

        } else if (e.getSource() == pinchange) {
            setVisible(false);
            new pinChange(pinnumber).setVisible(true);

        } else if (e.getSource() == BalanceEnquire) {
            setVisible(false);
            new balanceEnquiry(pinnumber).setVisible(true);

        } else if (e.getSource() == miniStatement) {

            new miniStatement(pinnumber).setVisible(true);

        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
