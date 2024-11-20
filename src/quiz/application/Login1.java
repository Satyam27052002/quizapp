package quiz.application;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login1 extends JFrame implements ActionListener
{
    JTextField tfname;
    JButton back, rules;
    Login1() 
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
                GradientPaint gradient = new GradientPaint(0, 0, Color.BLUE, width, height, Color.BLACK);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, width, height);
            }
        };
        gradientPanel.setLayout(null); // Set null layout
        setContentPane(gradientPanel); // Set gradientPanel as the content pane

        // Add first image
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/Login1.png"));
        Image img2 = img1.getImage();
        Image resizedImg1 = img2.getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(resizedImg1);
        JLabel image1 = new JLabel(i1);
        image1.setBounds(0, 10, 350, 350);
        gradientPanel.add(image1);

        // Add second image
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/mountain.png"));
        Image img4 = img.getImage();
        Image resizedImg2 = img4.getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(resizedImg2);
        JLabel image2 = new JLabel(i2);
        image2.setBounds(940, 380, 350, 350);
        gradientPanel.add(image2);

        // Heading
        JLabel heading = new JLabel("<html><pre>Every question is an <br>     opportunity to learn something new!!!</pre></html>");
        heading.setBounds(360, 0, 900, 300);
        heading.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        heading.setForeground(Color.GREEN);
        gradientPanel.add(heading);

        // Name label
        JLabel name = new JLabel("Enter Your Name:");
        name.setBounds(360, 0, 900, 700);
        name.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        name.setForeground(Color.GREEN);
        gradientPanel.add(name);

        // Gradient TextField for name
        tfname = new JTextField() 
        {
            @Override
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                int width = getWidth();
                int height = getHeight();

                // Create a gradient similar to the panel
                GradientPaint gradient = new GradientPaint(0, 0, Color.BLUE, width, height, Color.BLACK);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, width, height);
                g2d.dispose();
                super.paintComponent(g); // Paint text after gradient
            }
        };
        tfname.setBounds(360, 380, 510, 50);
        tfname.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        tfname.setForeground(Color.GREEN);
        tfname.setOpaque(false); // Make background transparent
//        tfname.setBorder(null);
        tfname.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1)); // Optional border
        gradientPanel.add(tfname);

        // Rules button
        rules = new JButton("Rules");
        rules.setBounds(420, 470, 150, 50);
        rules.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        rules.setForeground(Color.GREEN);
        rules.setBackground(Color.BLACK);
        rules.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set pointer cursor
        rules.setOpaque(false);
        rules.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        rules.addActionListener(this);
        gradientPanel.add(rules);

        // Back button
        back = new JButton("Back");
        back.setBounds(660, 470, 150, 50);
        back.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        back.setForeground(Color.GREEN);
        back.setBackground(Color.BLACK);
        back.setOpaque(false);
        back.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        back.addActionListener(this);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set pointer cursor
        gradientPanel.add(back);


        // Frame settings
        setBounds(0, 0, 1920, 1200); // Size of the content pane
        setVisible(true); // Visibility of the content pane
    }
    public void  actionPerformed(ActionEvent ae)
    {
        String name=tfname.getText();
        if(ae.getSource()==rules)
        {
            setVisible(false);
            new Rules1(name);
        }
        
        else if(ae.getSource()==back)
        {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Login1();
    }
}
