package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Score extends JFrame implements ActionListener
{
    Score(String name,int score)
    {
        setBounds(300,50,600,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/score.jpg"));
        Image img1=img.getImage();
        Image resizedImg=img1.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i1=new ImageIcon(resizedImg);
        JLabel image =new JLabel(i1);
        image.setBounds(100, 0, 400, 200);
        add(image);
        
        JLabel heading=new JLabel("Thankyou "+name+" for attending quiz.");
        heading.setBounds(150,220,500,30);
        heading.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(heading);
        
        JLabel scores=new JLabel("Your score is "+score);
        scores.setBounds(220,260,400,30);
        scores.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(scores);
        
        JButton play =new JButton("Play Again");
        play.setBounds(220,300,120,25);
        play.setBackground(Color.GRAY);
        play.setForeground(Color.WHITE);
        play.addActionListener(this);
        add(play);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) 
    {
        new Score("User",0);
    }
}
