package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener {


    JTextField panNoTextField, aadharNoTextField;
    JButton next;
    JRadioButton eano, eayes, syes, sno;
    JLabel additionalDetails, religion, category, income, education, qualification, occupation, panNo, aadharNo, seniorCitizen, existingAccount;
    ButtonGroup seniorGroup, eaGroup;
    JComboBox religion1, category1, income1, occupation1, educational1;
    String formno;

    Signup2(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FRMO - PAGE 2");

        additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80,400,30);
        add(additionalDetails);

        religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140,100,30);
        add(religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion1 = new JComboBox(valReligion);
        religion1.setBounds(300, 140, 400, 30);
        religion1.setBackground(Color.WHITE);
        add(religion1);

        category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190,200,30);
        add(category);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category1 = new JComboBox(valCategory);
        category1.setBounds(300, 190, 400, 30);
        category1.setBackground(Color.WHITE);
        add(category1);

        income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240,200,30);
        add(income);

        String valincome[] = {"Null", "< 150,000", "< 250,000", "< 500,000", "Upto 10,00,000"};
        income1 = new JComboBox(valincome);
        income1.setBounds(300, 240, 400, 30);
        income1.setBackground(Color.WHITE);
        add(income1);

        education = new JLabel("Educational");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 290,200,30);
        add(education);

        qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315,200,30);
        add(qualification);

        String valeducational[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctrate", "Others"};
        educational1 = new JComboBox(valeducational);
        educational1.setBounds(300, 315, 400, 30);
        educational1.setBackground(Color.WHITE);
        add(educational1);

        occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390,200,30);
        add(occupation);

        String valoccupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired","Others"};
        occupation1 = new JComboBox(valoccupation);
        occupation1.setBounds(300, 390, 400, 30);
        occupation1.setBackground(Color.WHITE);
        add(occupation1);

        panNo = new JLabel("PAN Number :");
        panNo.setFont(new Font("Raleway", Font.BOLD, 20));
        panNo.setBounds(100, 440,200,30);
        add(panNo);

        panNoTextField = new JTextField();
        panNoTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panNoTextField.setBounds(300, 440, 400, 30);
        add(panNoTextField);

        aadharNo = new JLabel("Aadhar Number :");
        aadharNo.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharNo.setBounds(100, 490,200,30);
        add(aadharNo);

        aadharNoTextField = new JTextField();
        aadharNoTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharNoTextField.setBounds(300, 490, 400, 30);
        add(aadharNoTextField);

        seniorCitizen = new JLabel("Senior Citizen :");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 540,200,30);
        add(seniorCitizen);

        syes = new JRadioButton("Yes");
        syes.setBounds(350,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(460,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);


        existingAccount = new JLabel("Existing Account :");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 590,200,30);
        add(existingAccount);

        eayes = new JRadioButton("Yes");
        eayes.setBounds(350,590,100,30);
        eayes.setBackground(Color.WHITE);
        add(eayes);

        eano = new JRadioButton("No");
        eano.setBounds(460,590,100,30);
        eano.setBackground(Color.WHITE);
        add(eano);

        eaGroup = new ButtonGroup();
        eaGroup.add(eayes);
        eaGroup.add(eano);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        String sreligion = (String) religion1.getSelectedItem();
        String scategory = (String) category1.getSelectedItem();
        String sincome = (String) income1.getSelectedItem();
        String seducation = (String) educational1.getSelectedItem();
        String soccupation = (String) occupation1.getSelectedItem();

        String senciti = null;
        if (syes.isSelected()) {
            senciti = "Yes";
        } else if(sno.isSelected()) {
            senciti = "No";
        }

        String eaacc = null;
        if(eayes.isSelected()) {
            eaacc = "Yes";
        } else if(eano.isSelected()) {
            eaacc = "No";
        }
        String span = panNoTextField.getText();
        String saadhar = aadharNoTextField.getText();

        try {

                Conn c = new Conn();
                String query = "insert into signup2 values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+senciti+"', '"+eaacc+"')";
                c.s.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    public static void main(String[] args) {
        new Signup2("");

    }
}
