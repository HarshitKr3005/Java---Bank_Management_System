package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JLabel image, text;
    JTextField amount;
    JButton withdraw, back;
    String pinnumber;

    Withdrawal(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            } else {
                try {
                    Conn conn = new Conn();


                    String query = "SELECT * FROM bank WHERE pin = '" + pinnumber + "'";
                    ResultSet rs = conn.s.executeQuery(query);
                    int balance = 0;
                    while (rs.next()) {
                        String type = rs.getString("type");
                        int amt = Integer.parseInt(rs.getString("amount"));
                        if (type.equals("Deposit")) {
                            balance += amt;
                        } else {
                            balance -= amt;
                        }
                    }


                    int withdrawAmount = Integer.parseInt(number);
                    if (withdrawAmount > balance) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance");
                        return;
                    }


                    String withdrawQuery = "INSERT INTO bank VALUES('" + pinnumber + "', '" + date + "', 'Withdrawal', '" + number + "')";
                    conn.s.executeUpdate(withdrawQuery);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " withdrawn successfully.");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
