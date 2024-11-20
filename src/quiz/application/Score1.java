package quiz.application;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Score1 extends JFrame implements ActionListener
{
    Score1(String name,int score)
    {
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
                GradientPaint gradient = new GradientPaint(0,-300, Color.BLUE, width, height, Color.BLACK);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, width, height);
            }
        };
        gradientPanel.setLayout(null); // Set null layout
        setContentPane(gradientPanel); // Set gradientPanel as the content pane
        
        JLabel heading=new JLabel("Thank you "+name+" for playing.");
        heading.setFont(new Font("Comic Sans MS",Font.PLAIN,25));
        heading.setForeground(Color.RED);
        heading.setBounds(50,20,600,50);
        gradientPanel.add(heading);
        
        JLabel scores=new JLabel("Your Score is "+score+" .");
        scores.setFont(new Font("Comic Sans MS",Font.PLAIN,25));
        scores.setForeground(Color.RED);
        scores.setBounds(120,60,600,50);
        gradientPanel.add(scores);
        
        JButton play=new JButton("Play Again");
        play.setFont(new Font("Comic Sans MS",Font.PLAIN,25));
        play.setForeground(Color.RED);
        play.setBounds(135,150,150,50);
        play.setBackground(Color.BLACK);
        play.setOpaque(false);
        play.setBorder(BorderFactory.createLineBorder(Color.RED,2));
        play.addActionListener(this);
        play.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gradientPanel.add(play);
        
        setBounds(400,140,450,350);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
        new Login1();
    }
    public static void main(String[] args) 
    {
        new Score1("User",0);
    }
}
