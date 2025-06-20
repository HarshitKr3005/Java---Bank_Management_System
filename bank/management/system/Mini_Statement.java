package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini_Statement extends JFrame {

    String pinnumber;
    JButton back;
    JLabel mini, bank, card, balance;

    Mini_Statement(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        setTitle("Mini Statement");

        mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        balance = new JLabel();
        balance.setBounds(20,400,320,20);
        add(balance);

        bank = new JLabel("Bank of America");
        bank.setBounds(150,20,100,20);
        add(bank);

        card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin_number = '"+pinnumber+"'");
            while(rs.next()) {
                card.setText("Card Number: " + rs.getString("card_number").substring(0, 4) + "XXXXXXXX" + rs.getString("card_number").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs " + bal);
        } catch (Exception e) {
            System.out.println(e);
        }



        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Mini_Statement("");
    }
}
