//package quiz.application;
//
//import java.awt.*;
//import javax.swing.*;
//import java.awt.event.*;
//
//public class Quiz extends JFrame implements ActionListener
//{
//    String questions[][]=new String[10][5];
//    String answers[][]=new String[10][2];
//    String userans[][]=new String[10][1];
//    JLabel qno;
//    JLabel question;
//    ButtonGroup group;
//    JRadioButton opt1,opt2,opt3,opt4;
//    JButton next,submit;
//    public static int timer=20;
//    public static int ans_given=0;
//    public static int count=0;
//    public static int score=0;
//    String name;
//    Quiz(String name)
//    {
//        this.name=name;
//        setBounds(120,20,800,600);
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//        
//        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
//        Image img1=img.getImage();
//        Image resizedImg=img1.getScaledInstance(800, 200, Image.SCALE_SMOOTH);
//        ImageIcon i1=new ImageIcon(resizedImg);
//        JLabel image =new JLabel(i1);
//        image.setBounds(0, 0, 800, 200);
//        add(image);
//        
//        qno=new JLabel();
//        qno.setBounds(50,220,50,30);
//        qno.setFont(new Font("Times New Roman",Font.PLAIN,20));
//        add(qno);
//        
//        question=new JLabel();
//        question.setBounds(80,220,700,30);
//        question.setFont(new Font("Times New Roman",Font.PLAIN,20));
//        add(question);
//        
//        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
//        questions[0][1] = "JVM";
//        questions[0][2] = "JDB";
//        questions[0][3] = "JDK";
//        questions[0][4] = "JRE";
//        
//        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
//        questions[1][1] = "int";
//        questions[1][2] = "Object";
//        questions[1][3] = "long";
//        questions[1][4] = "void";
//
//        questions[2][0] = "Which package contains the Random class?";
//        questions[2][1] = "java.util package";
//        questions[2][2] = "java.lang package";
//        questions[2][3] = "java.awt package";
//        questions[2][4] = "java.io package";
//
//        questions[3][0] = "An interface with no fields or methods is known as?";
//        questions[3][1] = "Runnable Interface";
//        questions[3][2] = "Abstract Interface";
//        questions[3][3] = "Marker Interface";
//        questions[3][4] = "CharSequence Interface";
//
//        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
//        questions[4][1] = "Stack";
//        questions[4][2] = "String memory";
//        questions[4][3] = "Random storage space";
//        questions[4][4] = "Heap memory";
//
//        questions[5][0] = "Which of the following is a marker interface?";
//        questions[5][1] = "Runnable interface";
//        questions[5][2] = "Remote interface";
//        questions[5][3] = "Readable interface";
//        questions[5][4] = "Result interface";
//
//        questions[6][0] = "Which keyword is used for accessing the features of a package?";
//        questions[6][1] = "import";
//        questions[6][2] = "package";
//        questions[6][3] = "extends";
//        questions[6][4] = "export";
//
//        questions[7][0] = "In java, jar stands for?";
//        questions[7][1] = "Java Archive Runner";
//        questions[7][2] = "Java Archive";
//        questions[7][3] = "Java Application Resource";
//        questions[7][4] = "Java Application Runner";
//
//        questions[8][0] = "Which of the following is a mutable class in java?";
//        questions[8][1] = "java.lang.StringBuilder";
//        questions[8][2] = "java.lang.Short";
//        questions[8][3] = "java.lang.Byte";
//        questions[8][4] = "java.lang.String";
//
//        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
//        questions[9][1] = "Bytecode is executed by JVM";
//        questions[9][2] = "The applet makes the Java code secure and portable";
//        questions[9][3] = "Use of exception handling";
//        questions[9][4] = "Dynamic binding between objects";
//        
//        answers[0][1] = "JDB";
//        answers[1][1] = "int";
//        answers[2][1] = "java.util package";
//        answers[3][1] = "Marker Interface";
//        answers[4][1] = "Heap memory";
//        answers[5][1] = "Remote interface";
//        answers[6][1] = "import";
//        answers[7][1] = "Java Archive";
//        answers[8][1] = "java.lang.StringBuilder";
//        answers[9][1] = "Bytecode is executed by JVM";
//        
//        opt1=new JRadioButton();
//        opt1.setBounds(60,250,700,30);
//        opt1.setBackground(Color.WHITE);
//        add(opt1);
//        
//        opt2=new JRadioButton();
//        opt2.setBounds(60,280,700,30);
//        opt2.setBackground(Color.WHITE);
//        add(opt2);
//        
//        opt3=new JRadioButton();
//        opt3.setBounds(60,310,700,30);
//        opt3.setBackground(Color.WHITE);
//        add(opt3);
//        
//        opt4=new JRadioButton();
//        opt4.setBounds(60,340,700,30);
//        opt4.setBackground(Color.WHITE);
//        add(opt4);
//        
//        group=new ButtonGroup();
//        group.add(opt1);
//        group.add(opt2);
//        group.add(opt3);
//        group.add(opt4);
//        
//        next=new JButton("Next");
//        next.setBounds(230,450,100,30);
//        next.setBackground(Color.BLACK);
//        next.setForeground(Color.WHITE);
//        next.addActionListener(this);
//        add(next);
//        
//        submit=new JButton("Submit");
//        submit.setBounds(430,450,100,30);
//        submit.setBackground(Color.BLACK);
//        submit.setForeground(Color.WHITE);
//        submit.addActionListener(this);
//        submit.setEnabled(false);
//        add(submit);
//        
//        start(count);
//        
//        setVisible(true);
//    }
//    public void actionPerformed(ActionEvent ae)
//    {
//        if(ae.getSource()==next)
//        {
//            repaint();
//            opt1.setEnabled(true);
//            opt2.setEnabled(true);
//            opt3.setEnabled(true);
//            opt4.setEnabled(true);
//            
//            ans_given=1;
//            if(count==8)
//            {
//                next.setEnabled(false);
//                submit.setEnabled(true);
//            }
//            count++;
//            start(count);
//        }
//        else if(ae.getSource()==submit)
//        {
//            ans_given=1;
//            if(group.getSelection()==null)
//            {
//                userans[count][0]="";
//            }
//            else
//            {
//                userans[count][0]=group.getSelection().getActionCommand();
//            }
//            for(int i=0;i<userans.length;i++)
//            {
//                if(userans[i][0].equals(answers[i][1]))
//                {  
//                    score+=2;
//                }
//            }
//            setVisible(false);
//            new Score(name,score);
//        }
//    }
//    public void paint(Graphics g)
//    {
//        super.paint(g);
//        String time="Time left - "+timer+" seconds";
//        g.setColor(Color.RED);
//        g.setFont(new Font("Calibri",Font.BOLD,20));
//        if(timer>0)
//        {
//            g.drawString(time,600,248);
//        }
//        else
//        {
//            g.drawString("TIME UP!!!",600,248);
//        }
//        timer--;
//        try
//        {
//            Thread.sleep(1000);
//            repaint();
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//        if(ans_given==1)
//        {
//            ans_given=0;
//            timer=20;
//        }
//        else if(timer<=0)
//        {
//            timer=20;
//            if(count==8)
//            {
//                next.setEnabled(false);
//                submit.setEnabled(true);
//            }
//            if(count==9)//submit
//            {
//                if(group.getSelection()==null)
//                {
//                    userans[count][0]="";
//                }
//                else
//                {
//                    userans[count][0]=group.getSelection().getActionCommand();
//                }
//                for(int i=0;i<userans.length;i++)
//                {
//                    if(userans[i][0].equals(answers[i][1]))
//                    {  
//                        score+=2;
//                    }
//                }
//                setVisible(false);
//                new Score(name,score);
//            }
//            else//next button
//            {
//                if(group.getSelection()==null)
//                {
//                    userans[count][0]="";
//                }
//                else
//                {
//                    userans[count][0]=group.getSelection().getActionCommand();
//                }
//                count++;
//                start(count);
//            }
//        }
//    }
//    public void start(int count)
//    {
//        qno.setText(""+(count+1)+". ");
//        question.setText(questions[count][0]);
//        opt1.setText(questions[count][1]);
//        opt1.setActionCommand(questions[count][1]);
//        
//        opt2.setText(questions[count][2]);
//        opt2.setActionCommand(questions[count][2]);
//
//        opt3.setText(questions[count][3]);
//        opt3.setActionCommand(questions[count][3]);
//
//        opt4.setText(questions[count][4]);
//        opt4.setActionCommand(questions[count][4]);
//        
//        group.clearSelection();
//    }
//    public static void main(String[] args)
//    {
//        new Quiz("User");
//    }
//}
package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String userans[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    JButton next, submit;
    ButtonGroup group;
    public static int timer = 20;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(120, 20, 800, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        Image img1 = img.getImage();
        Image resizedImg = img1.getScaledInstance(800, 200, Image.SCALE_SMOOTH);
        ImageIcon i1 = new ImageIcon(resizedImg);
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 800, 200);
        add(image);

        qno = new JLabel();
        qno.setBounds(50, 220, 50, 30);
        qno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(qno);

        question = new JLabel();
        question.setBounds(80, 220, 700, 30);
        question.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(question);

        opt1 = new JRadioButton();
        opt1.setBounds(60, 250, 700, 30);
        opt1.setBackground(Color.WHITE);
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(60, 280, 700, 30);
        opt2.setBackground(Color.WHITE);
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(60, 310, 700, 30);
        opt3.setBackground(Color.WHITE);
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(60, 340, 700, 30);
        opt4.setBackground(Color.WHITE);
        add(opt4);

        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);

        next = new JButton("Next");
        next.setBounds(230, 450, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(430, 450, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        addQuestionsAndAnswers();
        start(count);

        setVisible(true);
    }

    private void addQuestionsAndAnswers() {
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

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            if (group.getSelection() == null) {
                userans[count][0] = "";
            } else {
                userans[count][0] = group.getSelection().getActionCommand();
            }

            if (userans[count][0].equals(answers[count][1])) {
                score += 2;
            }

            timer = 20; // Reset timer
            if (count == 8)//9th que 
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count); // Move to the next question
        } else if (ae.getSource() == submit) {
            if (group.getSelection() == null) {
                userans[count][0] = "";
            } else {
                userans[count][0] = group.getSelection().getActionCommand();
            }

            if (userans[count][0].equals(answers[count][1])) {
                score += 2;
            }

            setVisible(false);
            new Score(name, score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time left - " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Calibri", Font.BOLD, 20));

        if (timer > 0) {
            g.drawString(time, 600, 248);
        } else {
            g.drawString("TIME UP!!!", 600, 248);
        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 20;
        } else if (timer < 0) {
            timer = 20;
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // Submit when timer ends at the last question
                if (group.getSelection() == null) {
                    userans[count][0] = "";
                } else {
                    userans[count][0] = group.getSelection().getActionCommand();
                }

                if (userans[count][0].equals(answers[count][1])) {
                    score += 2;
                }
                setVisible(false);
                new Score(name, score);
            } else {
                if (group.getSelection() == null) {
                    userans[count][0] = "";
                } else {
                    userans[count][0] = group.getSelection().getActionCommand();
                }

                if (userans[count][0].equals(answers[count][1])) {
                    score += 2;
                }
                count++;
                start(count);
            }
        }
    }

    public void start(int count) {
        qno.setText((count + 1) + ". ");
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

    public static void main(String[] args) {
        new Quiz("User");
    }
}
