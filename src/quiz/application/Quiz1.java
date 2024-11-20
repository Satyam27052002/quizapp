package quiz.application;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Quiz1 extends JFrame implements ActionListener
{
    String name;
    JLabel qno,question;
    JRadioButton opt1, opt2, opt3, opt4;
    JButton next, submit;
    ButtonGroup group;
    String questions[][]=new String[10][5];
    String answers[][]=new String[10][2];
    String userans[][]=new String[10][1];
    public static int count=0;
    public static int ansgiven=0;
    public static int score=0;
    public static int timer=20;
    
    Quiz1(String name)
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
                GradientPaint gradient = new GradientPaint(0,-300, Color.BLUE, width, height, Color.BLACK);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, width, height);
            }
        };
        gradientPanel.setLayout(null); // Set null layout
        setContentPane(gradientPanel); // Set gradientPanel as the content pane
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/question.png"));
        Image im=img.getImage();
        Image resizedIm=im.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon im1=new ImageIcon(resizedIm);
        JLabel image = new JLabel(im1);
        image.setBounds(1050, 260, 200, 200);
        gradientPanel.add(image);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        Image img2 = img1.getImage();
        Image resizedImg = img2.getScaledInstance(1300, 260, Image.SCALE_SMOOTH);
        ImageIcon i1 = new ImageIcon(resizedImg);
        JLabel image1 = new JLabel(i1);
        image1.setBounds(0, 0, 1300, 260);
        gradientPanel.add(image1);
        
        qno=new JLabel();
        qno.setBounds(40,270,700,50);
        qno.setForeground(Color.CYAN);
        qno.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        gradientPanel.add(qno);
        
        question = new JLabel();
        question.setBounds(75, 270, 900, 50);
        question.setForeground(Color.CYAN);
        question.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        gradientPanel.add(question);
        
        opt1 = new JRadioButton();
        opt1.setBounds(55, 320, 700, 30);
        opt1.setForeground(Color.CYAN);
        opt1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        opt1.setOpaque(false); // Makes the background transparent
        gradientPanel.add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(55, 350, 700, 30);
        opt2.setForeground(Color.CYAN);
        opt2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        opt2.setOpaque(false); // Makes the background transparent
        gradientPanel.add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(55, 380, 700, 30);
        opt3.setForeground(Color.CYAN);
        opt3.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        opt3.setOpaque(false); // Makes the background transparent
        gradientPanel.add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(55, 410, 700, 30);
        opt4.setForeground(Color.CYAN);
        opt4.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        opt4.setOpaque(false); // Makes the background transparent
        gradientPanel.add(opt4);

        // Group radio buttons
        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);
        
        //next
        next = new JButton("Next");
        next.setBounds(300,570,150,50);
        next.setFont(new Font("Comic Sans MS",Font.PLAIN,25));
        next.setForeground(Color.CYAN);
        next.setBackground(Color.BLACK);
        next.setOpaque(false);
        next.setBorder(BorderFactory.createLineBorder(Color.CYAN,2));
        next.addActionListener(this);
        next.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gradientPanel.add(next);
        
        //submit
        submit = new JButton("Submit");
        submit.setBounds(600,570,150,50);
        submit.setFont(new Font("Comic Sans MS",Font.PLAIN,25));
        submit.setForeground(Color.CYAN);
        submit.setBackground(Color.BLACK);
        submit.setOpaque(false);
        submit.setBorder(BorderFactory.createLineBorder(Color.CYAN,2));
        submit.addActionListener(this);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.setEnabled(false);
        gradientPanel.add(submit);
        
        //loading the questions and answers
        addQuestionsAnswers();
        start(count);
        
        setBounds(0, 0, 1920, 1200);
        setVisible(true);
    }
    
    void addQuestionsAnswers()
    {
        questions[0][0] = "Which is used to find and fix bugs in the Java programs?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
    }
    public void  actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==next)
        {
            //checking wheather user selected any option or not
            if(group.getSelection()==null)
            {
                userans[count][0]="";
            }
            else
            {
                userans[count][0]=group.getSelection().getActionCommand();
            }
            //checking user answer is correct or not
            if(userans[count][0].equals(answers[count][1]))
            {
                score+=2;
            }
            //reset timer
            timer=20;
            
            //enabling the submit button and disabling the next button
            if(count==8)//when the user is at 9th question
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }
        else if(ae.getSource()==submit)
        {
            //checking wheather user selected any option or not
            if(group.getSelection()==null)
            {
                userans[count][0]="";
            }
            else
            {
                userans[count][0]=group.getSelection().getActionCommand();
            }
            //checking user answer is correct or not
            if(userans[count][0].equals(answers[count][1]))
            {
                score+=2;
            }
            setVisible(false);
            new Score1(name,score);
        }
    }
    public void start(int count)
    {
        qno.setText((count+1)+". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        group.clearSelection();
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        String time="Time left- "+timer+" seconds";
        g.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
        if(timer<=10)
        {
            g.setColor(Color.RED);
        }
        else
        {
            g.setColor(Color.GREEN);
        }
        if(timer>0)
        {
            g.drawString(time,1050,500);
        }
        else
        {
            if(count==9)
            {
                g.drawString("Time up!!!", 1110, 500);
            }
        }
        timer--;
        try
        {
            Thread.sleep(1000);
            repaint();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if(ansgiven==1)
        {
            ansgiven=0;
            timer=20;
        }
        else if(timer<0)
        {
            timer=20;
            if(count==8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count==9)
            {
                if(group.getSelection()==null)
                {
                    userans[count][0]="";
                }
                else
                {
                    userans[count][0]=group.getSelection().getActionCommand();
                }
                if(userans[count][0].equals(answers[count][1]))
                {
                    score+=2;
                }
                setVisible(false);
                new Score1(name,score);
            }
            else
            {
                if(group.getSelection()==null)
                {
                    userans[count][0]="";
                }
                else
                {
                    userans[count][0]=group.getSelection().getActionCommand();
                }
                if(userans[count][0].equals(answers[count][1]))
                {
                    score+=2;
                }
                count++;
                start(count);
            }
        }
    }
    public static void main(String[] args)
    {
        new Quiz1("user");
    }
}
