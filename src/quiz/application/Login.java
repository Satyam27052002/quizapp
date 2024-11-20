package quiz.application;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener
{
    JButton rules,back;
    JTextField tfname;
    Login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image img1=img.getImage();
        Image resizedImg=img1.getScaledInstance(400, 600, Image.SCALE_SMOOTH);
        ImageIcon i1=new ImageIcon(resizedImg);
        JLabel image =new JLabel(i1);
//        image.setBounds(0, 0, 270, 500);
        image.setBounds(0, 0, 350, 500);
        add(image);
        
        JLabel heading=new JLabel("Quiz Time");
        heading.setBounds(450,60,300,45);
        heading.setFont(new Font("Mongolian Baiti",Font.BOLD,40));
        heading.setForeground(Color.GRAY);
        add(heading);
        
        JLabel name=new JLabel("Enter Your Name");
        name.setBounds(470,150,300,20);
        name.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        name.setForeground(Color.GRAY);
        add(name);
        
        tfname=new JTextField();
        tfname.setBounds(400,180,300,25);
        tfname.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(tfname);
        
        rules =new JButton("Rules");
        rules.setBounds(400,220,120,25);
        rules.setBackground(Color.GRAY);
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);
        
        back =new JButton("Back");
        back.setBounds(580,220,120,25);
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(800,500);
        setLocation(250,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==rules)
        {
            String name=tfname.getText();
            setVisible(false);
            new Rules(name);
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new Login();
    }
    
}
