
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Samar
 */
public class Javaproj2 extends JFrame{
    JLabel name=new JLabel("NAME");
    JLabel prn=new JLabel("PRN");
    JLabel city=new JLabel("CITY");
    JLabel gender=new JLabel("GENDER");
    JLabel branch=new JLabel("BRANCH");
    JLabel year=new JLabel("YEAR");
    JTextField t1=new JTextField(20);
    JTextField t2=new JTextField(20);
    JTextField t3=new JTextField(20);
    ButtonGroup bg;
    JRadioButton b1=new JRadioButton("MALE");
    JRadioButton b2=new JRadioButton("FEMALE");
    JComboBox stream;
    String[] opts={"comp.sci","mech","EnTC","CIVIL","IT"};
    String[] opts2={"FY","SY","TY","FINAL"};
    JComboBox batch;
    JButton sub=new JButton("SUBMIT");
    JButton can=new JButton("CANCEL");
    JButton back=new JButton("BACK");
    JLabel j1;
    JLabel j2;
    JLabel j3;
    JLabel j4;
    String gr1;
    class Subclass extends JFrame
    {
        Subclass(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String str=t1.getText();
        String str2=stream.getSelectedItem().toString();       
        String str3=batch.getSelectedItem().toString();
        String str4=t2.getText();
        j1=new JLabel(str);
        j2=new JLabel(str2);
        j3=new JLabel(str3);
        j4=new JLabel(str4);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;
        this.add(name,c);
        c.insets=new Insets(10,0,0,0);
        c.gridx=3;
        this.add(j1);
        c.gridx=0;
        c.gridy=1;
        this.add(branch,c);
        c.gridx=3;
        this.add(j2,c);
        c.gridx=0;
        c.gridy=2;
        this.add(year,c);
        c.gridx=3;
        this.add(j3,c);
        c.gridx=0;
        c.gridy=3;
        this.add(prn,c);
        c.gridx=3;
        this.add(j4,c);
        c.gridx=0;
        c.gridy=4;
        this.add(back,c);
        back.addActionListener(h1);
        }
    }
    Actionclass h1=new Actionclass();
    Javaproj2()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bg=new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        batch=new JComboBox(opts2);
        stream=new JComboBox(opts);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        c.insets=new Insets(10,0,0,0);
        c.gridx=0;
        c.gridy=0;
        this.add(name,c);
        c.gridx=2;
        this.add(t1,c);
        c.gridy=1;
        c.gridx=0;
        this.add(prn,c);
        c.gridx=2;
        this.add(t2,c);
        c.gridx=0;
        c.gridy=2;
        this.add(year,c);
        c.gridx=2;
        this.add(batch,c);
        c.gridx=0;
        c.gridy=3;
        this.add(branch,c);
        c.gridx=2;
        this.add(stream,c);
        c.gridx=0;
        c.gridy=4;
        this.add(gender,c);
        c.gridx=1;
        this.add(b1,c);
        c.gridx=2;
        this.add(b2,c);
        c.gridx=0;
        c.gridy=5;
        this.add(city,c);
        c.gridx=2;
        this.add(t3,c);
        c.gridx=0;
        c.gridy=6;
        this.add(sub,c);
        c.gridx=2;
        this.add(can,c);
        
        t1.addActionListener(h1);
        t2.addActionListener(h1);
        t3.addActionListener(h1);
        sub.addActionListener(h1);
        can.addActionListener(h1);
        b1.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
                gr1="MALE";
            }
            
        });
        b2.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
                gr1="FEMALE";
            }
            
        });
        stream.addItemListener(h1);
        batch.addItemListener(h1);
    }
    class Actionclass implements ActionListener,ItemListener{

        @Override
        public void actionPerformed(ActionEvent e) {
         
            String but=e.getActionCommand();
            System.out.println(but);
            String s1;
            String s2;
            String s3;
            String br;
            String yr;
            s1=t1.getText();
            s2=t2.getText();
            br=stream.getSelectedItem().toString();
           yr=batch.getSelectedItem().toString();
           int n=Integer.parseInt(s2);
            s3=t3.getText();
            int p=Integer.parseInt(s2);
            if(but.equals("SUBMIT"))
            {
                JOptionPane.showMessageDialog(null,"CREATING FORM.....");
                Subclass n1=new Subclass();
                n1.setSize(600,600);
                n1.setVisible(true);
                
                
        try
        {
            //DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","samar");
                    java.sql.Statement stmnt=con.createStatement();
            stmnt=con.createStatement();
            System.out.println("name"+s1);
            System.out.println("prn"+n);
            System.out.println("city"+s3);
            System.out.println("branch"+br);
            System.out.println("year"+yr);
            System.out.println("gender"+gr1);
            stmnt.executeUpdate("insert into java values ('"+s1+"','"+n+"','"+s3+"','"+br+"','"+yr+"','"+gr1+"')");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
            }
            else if(but.equals("CANCEL"))
            {
                JOptionPane.showMessageDialog(null,"REGISTRATION CANCELLED");
                System.exit(0);
            }
            else if(but.equals("BACK"))
            {
                JOptionPane.showMessageDialog(null,"GOING TO REGISTRATION DETAILS INPUT");
                Javaproj2 n2=new Javaproj2();
                n2.setSize(600,600);
                n2.setVisible(true);
                t1.setText(s1);
                t2.setText(s2);
                t3.setText(s3);
                
            }
        } 

        @Override
        public void itemStateChanged(ItemEvent e) {
            gr1=e.getItem().toString();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Javaproj2 f1=new Javaproj2();
        f1.setSize(600,600);
        f1.setVisible(true);
        // TODO code application logic here
    }
    
}
