package quiz.application;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Rules1 extends JFrame implements ActionListener
{
    String name;
    JButton back,start;
    Rules1(String name)
    {
        this.name=name;
        
        // Custom JPanel with gradient background
        JPanel gradientPanel = new JPanel() 
        {
            @Override
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();

                // Create a gradient color from blue to black
                GradientPaint gradient = new GradientPaint(0,400, Color.BLACK, width, height, Color.BLUE);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, width, height);
            }
        };
        gradientPanel.setLayout(null); // Set null layout
        setContentPane(gradientPanel); // Set gradientPanel as the content pane
        
        JLabel heading=new JLabel("Welcome "+name+" to JAVA Quiz");
        heading.setBounds(320,20,700,60);
        heading.setForeground(Color.CYAN);
        heading.setFont(new Font("Comic Sans MS", Font.BOLD, 45));
        gradientPanel.add(heading);
        
        JLabel heading1=new JLabel("Things to keep in mind!!!");
        heading1.setBounds(420,100,700,60);
        heading1.setForeground(Color.CYAN);
        heading1.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        gradientPanel.add(heading1);
        
        JLabel rules=new JLabel();
        rules.setBounds(50,100,800,440);
        rules.setForeground(Color.CYAN);
        rules.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        rules.setText(
        "<html>"+
                "1. There will be a total of 10 questions."+"<br>"+
                "2. For each question, you will have 20 seconds to answer."+"<br>"+
                "3. Each question carries 2 marks."+"<br>"+
                "4. For every correct answer 2 marks will be awarded."+"<br>"+
                "5. There is no negative markings. "+"<br>"+
                "6. Wish you all the best for your exam. Good luck!"+"<br>"+
        "</html");
        gradientPanel.add(rules);
        
        //back button
        back = new JButton("Back");
        back.setBounds(650,470,150,50);
        back.setFont(new Font("Comic Sans MS",Font.PLAIN,25));
        back.setForeground(Color.CYAN);
        back.setBackground(Color.BLACK);
        back.setOpaque(false);
        back.setBorder(BorderFactory.createLineBorder(Color.CYAN,5));
        back.addActionListener(this);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gradientPanel.add(back);
        
        // Start button
        start = new JButton("Start");
        start.setBounds(450,470,150,50);
        start.setFont(new Font("Comic Sans MS",Font.PLAIN,25));
        start.setForeground(Color.CYAN);
        start.setBackground(Color.BLACK);
        start.setOpaque(false);
        start.setBorder(BorderFactory.createLineBorder(Color.CYAN,5));
        start.addActionListener(this);
        start.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gradientPanel.add(start);
        
        setBounds(0, 0, 1920, 1200);
        setVisible(true);
    }
    public void  actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Login1();
        }
        else if(ae.getSource()==start)
        {
            setVisible(false);
            new Quiz1(name);
        }
    }
    
    public static void main(String[] args) 
    {
        new Rules1("User");
    }
}
