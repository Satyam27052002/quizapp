package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener
{
    String name;
    JButton start,back;
    Rules(String name)
    {
        this.name=name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);//default layout
        
        JLabel heading=new JLabel("Welcome "+name+" to Quiz Time");
        heading.setBounds(50,30,700,45);
        heading.setFont(new Font("Mongolian Baiti",Font.BOLD,28));
        heading.setForeground(Color.GRAY);
        add(heading);
        
        JLabel rules=new JLabel();
        rules.setBounds(30,0,600,350);
        rules.setFont(new Font("Mongolian Baiti",Font.PLAIN,18));
        rules.setText(
        "<html>"+
                "1. There are will be total 10 questions."+"<br>"+
                "2. For each question time will be given as 20 seconds."+"<br>"+
                "3. Each question will carry 2 marks."+"<br>"+
                "4. Wish you all the best for your exam, Good Luck"+"<br>"+
        "</html>");
        add(rules);
        
        back =new JButton("Back");
        back.setBounds(400,400,100,30);
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        start =new JButton("Start");
        start.setBounds(200,400,100,30);
        start.setBackground(Color.GRAY);
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        setSize(700,600);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==start)
        {
            setVisible(false);
            new Quiz(name);
        }
        else
        {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) 
    {
        new Rules("User");
    }
}
